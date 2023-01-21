package com.github.Th0rn_dev.restaurants_voting.repository;

import com.github.Th0rn_dev.restaurants_voting.model.Restaurant;
import com.github.Th0rn_dev.restaurants_voting.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.github.Th0rn_dev.restaurants_voting.model.Vote;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote> {
    @Query("SELECT v FROM Vote v WHERE v.votingDay = CURRENT_DATE ")
    List<Vote> findAllForCurrentDay();

    @Query("SELECT v From Vote v WHERE v.votingDay = CURRENT_DATE AND v.user=:user")
    Optional<Vote> findByUserForCurrentDay(User user);

    @Transactional
    @Modifying
    @Query("UPDATE Vote v SET v.restaurant=:restaurant WHERE v=:vote")
    int update(Vote vote, Restaurant restaurant);
}
