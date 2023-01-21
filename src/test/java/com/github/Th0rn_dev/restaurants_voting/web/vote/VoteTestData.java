package com.github.Th0rn_dev.restaurants_voting.web.vote;

import com.github.Th0rn_dev.restaurants_voting.model.Vote;
import com.github.Th0rn_dev.restaurants_voting.web.MatcherFactory;
import com.github.Th0rn_dev.restaurants_voting.web.user.UserTestData;

import static com.github.Th0rn_dev.restaurants_voting.web.RestaurantTestData.RESTAURANT_ONE;

public class VoteTestData {

    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Vote.class, "user.password", "user.registered");
    public static final String URL_VOTE_FOR_RESTAURANT_ONE = "restaurants/1/vote";
    public static final String URL_VOTE_FOR_RESTAURANT_TWO = "restaurants/2/vote";
    public static final String URL_VOTE_FOR_RESTAURANT_NOT_PRESENT = "restaurants/99/vote";

    public static final Vote vote = new Vote(2, RESTAURANT_ONE, UserTestData.user);

    public static Vote getNew() {
        return new Vote(null, RESTAURANT_ONE, UserTestData.user);
    }
}
