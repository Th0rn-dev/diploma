package com.github.Th0rn_dev.restaurants_voting.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.Th0rn_dev.restaurants_voting.web.ResultTestData.RESULT_TO_MATCHER;
import static com.github.Th0rn_dev.restaurants_voting.web.ResultTestData.getNew;
import static com.github.Th0rn_dev.restaurants_voting.web.user.UserTestData.USER_MAIL;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ResultControllerTest extends AbstractControllerTest {

    private static final String REST_URL = ResultController.REST_URL;

    @Test
    @WithUserDetails(value = USER_MAIL)
    void accessAuthorizedUser() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(RESULT_TO_MATCHER.contentJson(getNew()));
    }

    @Test
    void accessNotAuthorizedUser() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(RESULT_TO_MATCHER.contentJson(getNew()));
    }
}