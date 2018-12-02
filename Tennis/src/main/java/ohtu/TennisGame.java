package ohtu;

public class TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private static final int WIN_THRESHOLD = 4;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            playerOneScore += 1;
        } else {
            playerTwoScore += 1;
        }
    }

    private String equalScore() {
        switch (playerOneScore) {
            case 0:
                return  "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";

        }
    }

    private boolean scoreOverFour() {
        return playerOneScore >= WIN_THRESHOLD || playerTwoScore >= WIN_THRESHOLD;
    }

    private String scoreDifference(int pointDifference) {
        String score;
        if (pointDifference == 1) {
            score = "Advantage player1";
        } else if (pointDifference == -1) {
            score = "Advantage player2";
        } else if (pointDifference >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    public String getScore() {
        String score = "";
        if (playerOneScore == playerTwoScore) {
            score = equalScore();
        } else if (scoreOverFour()) {
            score = scoreDifference(playerOneScore - playerTwoScore);
        } else {
            score = buildScore(playerOneScore, score) + "-";
            score = buildScore(playerTwoScore, score);
        }
        return score;
    }

    private String buildScore(int currentScore, String score) {
        switch (currentScore) {
            case 0:
                return score += "Love";
            case 1:
                return score += "Fifteen";
            case 2:
                return score += "Thirty";
            case 3:
                return score += "Forty";
        }
        return score;
    }
}
