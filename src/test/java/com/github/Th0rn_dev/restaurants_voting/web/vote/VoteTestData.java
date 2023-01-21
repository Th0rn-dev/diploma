package com.github.Th0rn_dev.restaurants_voting.web.vote;

import com.github.Th0rn_dev.restaurants_voting.model.Restaurant;
import com.github.Th0rn_dev.restaurants_voting.web.MatcherFactory;
import com.github.Th0rn_dev.restaurants_voting.model.Vote;
import com.github.Th0rn_dev.restaurants_voting.web.user.UserTestData;

public class VoteTestData {

    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Vote.class, "user.password", "user.registered");
    public static final String URL_VOTE_FOR_RESTAURANT_ONE = "restaurants/1/vote";
    public static final String URL_VOTE_FOR_RESTAURANT_TWO = "restaurants/2/vote";
    public static final String URL_VOTE_FOR_RESTAURANT_NOT_PRESENT = "restaurants/99/vote";

    public static Restaurant restaurant1 = new Restaurant(1, "Тануки", "ул. Новая");

    public static final Vote vote = new Vote(2, restaurant1, UserTestData.user);

    public static Vote getNew() {
        return new Vote(null, restaurant1, UserTestData.user);
    }
}
