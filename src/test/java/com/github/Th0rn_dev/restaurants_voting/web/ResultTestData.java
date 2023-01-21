package com.github.Th0rn_dev.restaurants_voting.web;

import com.github.Th0rn_dev.restaurants_voting.to.ResultTo;

import java.util.ArrayList;
import java.util.List;

import static com.github.Th0rn_dev.restaurants_voting.web.RestaurantTestData.RESTAURANT_ONE;

public class ResultTestData {
    public static final MatcherFactory.Matcher<ResultTo> RESULT_TO_MATCHER = MatcherFactory.usingEqualsComparator(ResultTo.class);

    public static List<ResultTo> getNew() {
        List<ResultTo> lResults = new ArrayList<>();
        lResults.add(new ResultTo(RESTAURANT_ONE, 1L));
        return lResults;
    }
}
