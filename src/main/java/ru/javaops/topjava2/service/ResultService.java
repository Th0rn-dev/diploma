package ru.javaops.topjava2.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.model.Vote;
import ru.javaops.topjava2.repository.VoteRepository;
import ru.javaops.topjava2.to.ResultTo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ResultService {

    private final VoteRepository voteRepository;

    public ResultService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }


    public List<ResultTo> getVotesByRestaurants() {
        List<Vote> votes = voteRepository.findAllForCurrentDay();
        Map<Restaurant, Long> hmVoteCounts = votes.stream()
                .collect(Collectors.groupingBy(Vote::getRestaurant, Collectors.counting()));
        return hmVoteCounts.entrySet().stream()
                .map(r -> new ResultTo(r.getKey(), r.getValue()))
                .toList();
    }
}
