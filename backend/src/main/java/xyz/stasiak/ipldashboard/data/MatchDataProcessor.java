package xyz.stasiak.ipldashboard.data;

import org.springframework.batch.item.ItemProcessor;
import xyz.stasiak.ipldashboard.model.Match;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(MatchInput matchInput) {
        var id = Long.parseLong(matchInput.id());
        var city = matchInput.city();
        var date = LocalDate.parse(matchInput.date());
        var playerOfMatch = matchInput.player_of_match();
        var venue = matchInput.venue();
        var tossWinner = matchInput.toss_winner();
        var tossDecision = matchInput.toss_decision();

        String team1;
        String team2;
        if ("bat".equals(tossDecision)) {
            team1 = tossWinner;
            team2 = tossWinner.equals(matchInput.team1()) ? matchInput.team2() : matchInput.team1();
        } else {
            team1 = tossWinner.equals(matchInput.team1()) ? matchInput.team1() : matchInput.team2();
            team2 = tossWinner;
        }

        var matchWinner = matchInput.winner();
        var result = matchInput.result();
        var resultMargin = matchInput.result_margin();
        var umpire1 = matchInput.umpire1();
        var umpire2 = matchInput.umpire2();

        return new Match(id, city, date, playerOfMatch, venue, team1, team2, tossWinner, tossDecision, matchWinner,
                         result, resultMargin, umpire1, umpire2);
    }
}
