package xyz.stasiak.ipldashboard.model;

import java.time.LocalDate;

public record Match(long id, String city, LocalDate date, String playerOfMatch, String venue, String team1,
                    String team2, String tossWinner, String tossDecision, String matchWinner, String result,
                    String resultMargin, String umpire1, String umpire2) {

}
