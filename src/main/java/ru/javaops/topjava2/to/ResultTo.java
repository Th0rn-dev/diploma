package ru.javaops.topjava2.to;

import ru.javaops.topjava2.model.Restaurant;

import javax.validation.constraints.NotBlank;

public record ResultTo(@NotBlank Restaurant restaurant, @NotBlank Long countVotes) {
    public ResultTo(Restaurant restaurant, Long countVotes) {
        this.restaurant = restaurant;
        this.countVotes = countVotes;
    }
}
