package com.github.Th0rn_dev.restaurants_voting.repository;

import com.github.Th0rn_dev.restaurants_voting.model.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface MenuRepository extends BaseRepository<Menu> {
    @Query("SELECT m FROM Menu m WHERE m.created > CURRENT_DATE")
    List<Menu> findAllPresentDayMenu();
}