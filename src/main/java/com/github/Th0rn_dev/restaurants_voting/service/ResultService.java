package com.github.Th0rn_dev.restaurants_voting.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.github.Th0rn_dev.restaurants_voting.model.Restaurant;
import com.github.Th0rn_dev.restaurants_voting.model.Vote;
import com.github.Th0rn_dev.restaurants_voting.repository.VoteRepository;
import com.github.Th0rn_dev.restaurants_voting.to.ResultTo;

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
