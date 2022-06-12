package com.sample.application.poller;

import com.sample.application.service.ScoreBoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MatchPoller.class, ScoreBoardService.class})
@TestPropertySource(properties = {"match.poll.fixedDelay=1000","match.poll.initialDelay=1000"})
class MatchPollerTest {

    @Autowired
    MatchPoller matchPoller;
    @Autowired
    ScoreBoardService scoreBoardService;

    @Test
    void getSummariesTest(){
        matchPoller.triggerMatchPoller();
        assertThat(scoreBoardService.getSummary().size()).isPositive();
    }

}
