package tennis.domain.models;


public class Match {
    private Player playerA;
    private Player playerB;
    private boolean isEnded;
    private String finalScore;

    public Match(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.isEnded = false;
    }

    public void pointWonBy(String playerName) {
        if (isEnded) {
            return;
        }

        Player player = playerName.equals(playerA.getName()) ? playerA : playerB;
        Player opponent = getOpponent(player);

        if (player.getScore() == 40) {
            if (opponent.getScore() < 40) {
                setFinalScore(player.getName() + " wins the game");
                setEnded(true);
            } else if (opponent.getScore() == 40) {
                if (player.hasAdvantage()) {
                    setFinalScore(player.getName() + " wins the game");
                    setEnded(true);
                } else if (opponent.hasAdvantage()) {
                    opponent.resetAdvantage();
                } else {
                    player.setAdvantage(true);
                }
            }
        } else {
            player.winPoint();
        }
    }

    public String getCurrentScore() {
        if (isEnded) {
            return finalScore;
        }

        if (playerA.getScore() == 40 && playerB.getScore() == 40) {
            if (playerA.hasAdvantage()) {
                return "Player A: Advantage -- Player B: 40";
            } else if (playerB.hasAdvantage()) {
                return "Player A: 40 -- Player B: Advantage";
            } else {
                return "Player A: 40 -- Player B: 40 -- Deuce";
            }
        }

        return "Player A: " + scoreToString(playerA.getScore()) + " -- Player B: " + scoreToString(playerB.getScore());
    }

    public String getFinalScore() {
        return finalScore;
    }

    public boolean isEnded() {
        return isEnded;
    }

    private void setEnded(boolean ended) {
        isEnded = ended;
    }

    private void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }

    private String scoreToString(int score) {
        switch (score) {
            case 0: return "0";
            case 15: return "15";
            case 30: return "30";
            case 40: return "40";
            default: return String.valueOf(score);
        }
    }


    private Player getOpponent(Player player) {
        return player == playerA ? playerB : playerA;
    }
}
