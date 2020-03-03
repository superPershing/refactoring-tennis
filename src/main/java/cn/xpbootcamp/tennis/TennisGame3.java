package cn.xpbootcamp.tennis;

import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private int p2;
    private int p1;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String s;
        if (p1 < 4 && p2 < 4 && p1 + p2 != 6) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[p1];
            return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
        } else {
            if (p1 == p2)
                return "Deuce";
            s = p1 > p2 ? player1Name : player2Name;
            return ((p1 - p2) * (p1 - p2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            this.p1 += 1;
        else
            this.p2 += 1;

    }

}