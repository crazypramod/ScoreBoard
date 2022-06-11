package com.sample.application;

import com.sample.application.model.TeamInfo;

import java.util.Comparator;
import java.util.Set;

public class ScoreBoardComparator implements Comparator<Set<TeamInfo>> {
    @Override
    public int compare(Set<TeamInfo> match1Teams, Set<TeamInfo> match2Teams) {
        Integer match1Total = match1Teams.stream().mapToInt(TeamInfo::getGoalsScored).sum();
        Integer match2Total = match2Teams.stream().mapToInt(TeamInfo::getGoalsScored).sum();
        if (match2Total.equals(match1Total)) {
            return 1;
        }
        return match2Total.compareTo(match1Total);
    }
}
