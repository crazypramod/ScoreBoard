package com.sample.application.service;

import com.sample.application.ScoreBoardComparator;
import com.sample.application.exception.ScoreBoardRuntimeException;
import com.sample.application.model.Match;
import com.sample.application.model.TeamInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Component
public class ScoreBoardService {

    Map<String, Set<TeamInfo>> scoreBoard = new HashMap<>();

    public void manageMatches(Match[] matchList) {
        try {
            for (Match match : matchList) {
                String matchId = match.getId();
                boolean isMatchFinished = "completed".equals(match.getState());
                if (scoreBoard.containsKey(matchId)) {
                    if (isMatchFinished) {
                        scoreBoard.remove(matchId);
                    } else {
                        scoreBoard.replace(matchId, match.getTeamInfo());
                    }
                } else {
                    if (!isMatchFinished) {
                        scoreBoard.put(matchId, match.getTeamInfo());
                    }
                }
            }
        } catch (Exception e) {
            throw new ScoreBoardRuntimeException("Error occured while trying to manage matches: ", e);
        }
    }

    public Set<Set<TeamInfo>> getSummary() {
        try {
            Set<Set<TeamInfo>> sortedSet = new TreeSet<>(new ScoreBoardComparator());
            for (String matchId : scoreBoard.keySet()) {
                sortedSet.add(scoreBoard.get(matchId));
            }
            return sortedSet;
        } catch (Exception e) {
            throw new ScoreBoardRuntimeException("Error occured while trying to show summaries: ", e);
        }
    }

}
