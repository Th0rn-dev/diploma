package com.github.Th0rn_dev.restaurants_voting.repository;

import com.github.Th0rn_dev.restaurants_voting.model.Dish;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DishRepository extends BaseRepository<Dish> {

}