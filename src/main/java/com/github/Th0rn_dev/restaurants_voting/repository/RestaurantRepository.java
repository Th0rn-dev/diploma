package com.github.Th0rn_dev.restaurants_voting.repository;

import com.github.Th0rn_dev.restaurants_voting.model.Restaurant;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Transactional(readOnly = true)
public interface RestaurantRepository extends BaseRepository<Restaurant>{
    @Override
    Optional<Restaurant> findById(Integer integer);
}
