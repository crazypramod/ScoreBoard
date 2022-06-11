package com.sample.application.poller;

import com.sample.application.ApplicationUtil;
import com.sample.application.exception.ScoreBoardRuntimeException;
import com.sample.application.model.Match;
import com.sample.application.service.ScoreBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchPoller {

    private static final Logger logger = LoggerFactory.getLogger(MatchPoller.class);

    @Autowired
    private ScoreBoardService scoreBoardService;

    @Scheduled(fixedDelayString = "${match.poll.fixedDelay}", initialDelayString = "${match.poll.initialDelay}")
    public void triggerMatchPoller() {
        try {
            Match[] arrayOfMatches = ApplicationUtil.json2Java("data.json", Match[].class);
            if (arrayOfMatches != null && arrayOfMatches.length > 0) {
                scoreBoardService.manageMatches(arrayOfMatches);
                scoreBoardService.showSummary();
            }
        } catch (ScoreBoardRuntimeException e) {
            logger.error("Error occured while processing application: ", e);
        }
    }

}
