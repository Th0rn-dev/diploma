package ru.javaops.topjava2.web.vote;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.javaops.topjava2.model.Vote;
import ru.javaops.topjava2.repository.VoteRepository;
import ru.javaops.topjava2.util.ClockUtil;
import ru.javaops.topjava2.web.AbstractControllerTest;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javaops.topjava2.web.user.UserTestData.USER_MAIL;
import static ru.javaops.topjava2.web.vote.VoteTestData.URL_VOTE_FOR_RESTAURANT_NOT_PRESENT;
import static ru.javaops.topjava2.web.vote.VoteTestData.URL_VOTE_FOR_RESTAURANT_ONE;
import static ru.javaops.topjava2.web.vote.VoteTestData.VOTE_MATCHER;
import static ru.javaops.topjava2.web.vote.VoteTestData.getNew;
import static ru.javaops.topjava2.web.vote.VoteTestData.vote;

class VoteControllerTest extends AbstractControllerTest {

    private static final String REST_URL = VoteController.REST_URL + '/';

    @Autowired
    private VoteRepository repository;

    @Test
    @WithUserDetails(value = USER_MAIL)
    void countVoteForRestaurant() throws Exception {
        Vote newVote = getNew();
        ResultActions action = perform(MockMvcRequestBuilders.put(REST_URL + URL_VOTE_FOR_RESTAURANT_ONE)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        Vote created = VOTE_MATCHER.readFromJson(action);
        int newId = created.id();
        newVote.setId(newId);

        VOTE_MATCHER.assertMatch(created, newVote);
        VOTE_MATCHER.assertMatch(repository.findById(newId).get(), newVote);
    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void countVoteIfRestaurantNotPresent() throws Exception {
        perform(MockMvcRequestBuilders.put(REST_URL + URL_VOTE_FOR_RESTAURANT_NOT_PRESENT)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Disabled
    @Test
    @WithUserDetails(value = USER_MAIL)
    void voteChangeUpToElevenOClock() throws Exception {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime upToElevenOClock = LocalDateTime.of(
                now.getYear(), now.getMonth(), now.getDayOfMonth(), 10, 50);
        final Clock fixed = Clock.fixed(upToElevenOClock.toInstant(ZoneOffset.UTC), ZoneOffset.UTC);
        final Clock oldClock = ClockUtil.setClock(fixed);

        repository.save(vote);

//        perform(MockMvcRequestBuilders.put(REST_URL + URL_VOTE_FOR_RESTAURANT_TWO)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
    }
}