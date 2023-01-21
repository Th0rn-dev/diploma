package com.github.Th0rn_dev.restaurants_voting.service;


import com.github.Th0rn_dev.restaurants_voting.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.github.Th0rn_dev.restaurants_voting.model.Menu;
import com.github.Th0rn_dev.restaurants_voting.model.Restaurant;
import com.github.Th0rn_dev.restaurants_voting.model.Vote;
import com.github.Th0rn_dev.restaurants_voting.repository.MenuRepository;
import com.github.Th0rn_dev.restaurants_voting.repository.RestaurantRepository;
import com.github.Th0rn_dev.restaurants_voting.repository.VoteRepository;
import com.github.Th0rn_dev.restaurants_voting.util.ClockUtil;

import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VoteService {
    private final MenuRepository menuRepository;

    private final VoteRepository voteRepository;
    private final RestaurantRepository restaurantRepository;

    public VoteService(VoteRepository voteRepository, RestaurantRepository restaurantRepository,
                       MenuRepository menuRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    public ResponseEntity<Object> createOrUpdate(int restaurant_id, User user) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurant_id);

        if (restaurant.isEmpty()) {
            log.info("restaurant not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Set<Restaurant> restaurantsForVote = menuRepository.findAllPresentDayMenu().stream()
                .map(Menu::getRestaurant)
                .collect(Collectors.toSet());

        if (!restaurantsForVote.contains(restaurant.get())) {
            log.info("restaurant with id={} does not participate in the current voting", restaurant_id);
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Optional<Vote> vote = voteRepository.findByUserForCurrentDay(user);
        if (vote.isPresent()) {
            int hour = LocalTime.now(ClockUtil.getClock()).getHour();
            if (hour < 11) {
                log.info("vote id={} updating", vote.get());
                return new ResponseEntity<>(voteRepository.update(vote.get(), restaurant.get()), HttpStatus.OK);
            } else {
                log.info("vote update timed out for {}", vote.get());
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        }
        Vote newVote = voteRepository.save(new Vote(null, restaurant.get(), user));
        return new ResponseEntity<>(newVote, HttpStatus.CREATED);
    }
}
