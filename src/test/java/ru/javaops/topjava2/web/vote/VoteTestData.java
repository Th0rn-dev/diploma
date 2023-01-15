package ru.javaops.topjava2.web.vote;

import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.model.Vote;
import ru.javaops.topjava2.web.MatcherFactory;
import ru.javaops.topjava2.web.user.UserTestData;

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
