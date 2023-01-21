package com.github.Th0rn_dev.restaurants_voting.web;


import com.github.Th0rn_dev.restaurants_voting.service.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.Th0rn_dev.restaurants_voting.to.ResultTo;

import java.util.List;


@RestController
@RequestMapping(value = ResultController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ResultController {
    static final String REST_URL = "/api/results";

    protected ResultService service;

    ResultController(ResultService resultService) {
        this.service = resultService;
    }

    @GetMapping
    public List<ResultTo> getResult() {
        log.info("get result for current day");
        return service.getVotesByRestaurants();
    }

}
