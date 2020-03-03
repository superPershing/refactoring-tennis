package cn.xpbootcamp.tennis;

import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String winnerName;
        if (player1Score < 4 && player2Score < 4 && player1Score + player2Score != 6) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            winnerName = p[player1Score];
            return (player1Score == player2Score) ? winnerName + "-All" : winnerName + "-" + p[player2Score];
        }
        if (player1Score == player2Score)
            return "Deuce";
        winnerName = player1Score > player2Score ? player1Name : player2Name;
        return (Math.abs(player1Score - player2Score) == 1) ? "Advantage " + winnerName : "Win for " + winnerName;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            this.player1Score += 1;
        else
            this.player2Score += 1;

    }

}