package tennis.domain.services;


import tennis.domain.commands.Command;
import tennis.domain.commands.PlayerACommand;
import tennis.domain.commands.PlayerBCommand;
import tennis.domain.models.Match;
import tennis.domain.models.Player;


public class TennisScoreService {
    private Match match;

    public TennisScoreService() {
        this.match = new Match(new Player("Player A"), new Player("Player B"));
    }

    public void processPoints(String input) {
        for (int i = 0; i < input.length(); i++) {
            char point = input.charAt(i);

            if (point != 'A' && point != 'B') {
                throw new IllegalArgumentException("Invalid input: " + point);
            }

            Command command = createCommand(point);
            command.execute(match);

            if (match.isEnded()) {
                System.out.println(match.getFinalScore());
                if (i < input.length() - 1) {
                    throw new IllegalArgumentException("The game has already been won. Extra points in input sequence.");
                }
                break;
            } else {
                System.out.println(match.getCurrentScore());
            }
        }
    }

    public Match getMatch() {
        return match;
    }

    public void resetMatch() {
        this.match = new Match(new Player("Player A"), new Player("Player B"));
    }

    private Command createCommand(char point) {
        if (point == 'A') {
            return new PlayerACommand();
        } else if (point == 'B') {
            return new PlayerBCommand();
        }
        throw new IllegalArgumentException("Invalid input: " + point);
    }
}
