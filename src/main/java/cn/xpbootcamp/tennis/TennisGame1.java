package cn.xpbootcamp.tennis;

import java.util.Objects;

public class TennisGame1 implements TennisGame {
    public static String LOVE = "Love";
    public static String FIFTEEN = "Fifteen";
    public static String THIRTY = "Thirty";
    public static String FORTY = "Forty";
    public static String DEUCE = "Deuce";

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private static String getScoreWhenPointIsNotLessThan4(TennisGame1 game) {
        int minusResult = game.player1Score - game.player2Score;
        if (minusResult == 1) return "Advantage " + game.player1Name;
        if (minusResult == -1) return "Advantage " + game.player2Name;
        if (minusResult >= 2) return "Win for " + game.player1Name;
        return "Win for " + game.player2Name;
    }

    private static String getScoreWhenBothPointLessThan4(int player1Score, int player2Score) {
        return getScore(player1Score) + "-" + getScore(player2Score);
    }

    private static String getScore(int playerPoint) {
        String score;
        switch (playerPoint) {
            case 0:
                score = LOVE;
                break;
            case 1:
                score = FIFTEEN;
                break;
            case 2:
                score = THIRTY;
                break;
            case 3:
                score = FORTY;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + playerPoint);
        }
        return score;
    }

    private static String getScoreWhenEqual(int point) {
        if (point < 3) {
            return getScore(point) + "-All";
        }
        return DEUCE;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (isScoreEqual()) {
            return getScoreWhenEqual(player1Score);
        }
        if (isBothScoreIsLessThan4()) {
            return getScoreWhenBothPointLessThan4(player1Score, player2Score);
        }
        return getScoreWhenPointIsNotLessThan4(this);
    }

    private boolean isBothScoreIsLessThan4() {
        return player1Score < 4 && player2Score < 4;
    }

    private boolean isScoreEqual() {
        return player1Score == player2Score;
    }
}