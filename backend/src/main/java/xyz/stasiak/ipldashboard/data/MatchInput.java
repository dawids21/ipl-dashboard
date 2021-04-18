package xyz.stasiak.ipldashboard.data;

public record MatchInput(String id, String city, String date, String playerOfMatch, String venue, String team1,
                         String team2, String toss_winner, String toss_decision, String winner, String result,
                         String result_margin, String eliminator, String method, String umpire1, String umpire2) {

}
