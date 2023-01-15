package ru.javaops.topjava2.web.vote;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javaops.topjava2.model.User;
import ru.javaops.topjava2.model.Vote;
import ru.javaops.topjava2.repository.RestaurantRepository;
import ru.javaops.topjava2.repository.VoteRepository;
import ru.javaops.topjava2.service.VoteService;
import ru.javaops.topjava2.web.AuthUser;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value=VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class VoteController {

    static final String REST_URL = "/api/votes";
    protected VoteRepository voteRepository;

    protected RestaurantRepository restaurantRepository;

    protected VoteService service;

    public VoteController(VoteRepository voteRepository, RestaurantRepository restaurantRepository, VoteService service) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
        this.service = service;
    }

    @GetMapping
    public List<Vote> getAll() {
        log.info("getAll");
        return voteRepository.findAllForCurrentDay();
    }

    @PutMapping(value = "/restaurants/{restaurant_id}/vote")
    public ResponseEntity<?> countVoteForRestaurant(@Valid @PathVariable int restaurant_id, @AuthenticationPrincipal AuthUser authUser) {
        User user = authUser.getUser();
        log.info("Count the vote of the restaurant {} with authenticated user {}", restaurant_id, user.id());
        return service.createOrUpdate(restaurant_id, user);
    }


}
