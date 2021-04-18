package xyz.stasiak.ipldashboard.data;

import org.springframework.batch.item.ItemProcessor;
import xyz.stasiak.ipldashboard.model.Match;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(MatchInput matchInput) {
        var id = Long.parseLong(matchInput.getId());
        var city = matchInput.getCity();
        var date = LocalDate.parse(matchInput.getDate());
        var playerOfMatch = matchInput.getPlayer_of_match();
        var venue = matchInput.getVenue();
        var tossWinner = matchInput.getToss_winner();
        var tossDecision = matchInput.getToss_decision();

        String team1;
        String team2;
        if ("bat".equals(tossDecision)) {
            team1 = tossWinner;
            team2 = tossWinner.equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
        } else {
            team1 = tossWinner.equals(matchInput.getTeam1()) ? matchInput.getTeam1() : matchInput.getTeam2();
            team2 = tossWinner;
        }

        var matchWinner = matchInput.getWinner();
        var result = matchInput.getResult();
        var resultMargin = matchInput.getResult_margin();
        var umpire1 = matchInput.getUmpire1();
        var umpire2 = matchInput.getUmpire2();

        return new Match(id, city, date, playerOfMatch, venue, team1, team2, tossWinner, tossDecision, matchWinner,
                         result, resultMargin, umpire1, umpire2);
    }
}
