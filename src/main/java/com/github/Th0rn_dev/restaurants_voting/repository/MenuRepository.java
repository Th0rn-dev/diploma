package com.github.Th0rn_dev.restaurants_voting.repository;

import com.github.Th0rn_dev.restaurants_voting.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface MenuRepository extends BaseRepository<Menu> {
    List<Menu> findAllByDate(LocalDate date);
}