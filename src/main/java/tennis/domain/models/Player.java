package tennis.domain.models;

public class Player {
    private String name;
    private int score;
    private boolean advantage;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.advantage = false;
    }

    public void winPoint() {
        if (this.score == 30) {
            this.score = 40;
        } else if (this.score < 30) {
            this.score += 15;
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean hasAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }

    public void resetAdvantage() {
        this.advantage = false;
    }
}
