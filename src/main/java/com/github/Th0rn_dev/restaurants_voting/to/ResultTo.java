package com.github.Th0rn_dev.restaurants_voting.to;

import com.github.Th0rn_dev.restaurants_voting.model.Restaurant;

import javax.validation.constraints.NotBlank;

public record ResultTo(@NotBlank Restaurant restaurant, @NotBlank Long countVotes) {
    public ResultTo(Restaurant restaurant, Long countVotes) {
        this.restaurant = restaurant;
        this.countVotes = countVotes;
    }
}
