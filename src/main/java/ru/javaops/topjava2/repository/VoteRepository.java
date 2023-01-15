package ru.javaops.topjava2.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.model.User;
import ru.javaops.topjava2.model.Vote;

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
    @Query("UPDATE Vote v SET v.restaurant=?2")
    Vote update(Vote vote, Restaurant restaurant);
}
