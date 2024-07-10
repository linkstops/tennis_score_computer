package tennis;

import tennis.application.TennisGameConsole;
import tennis.domain.services.TennisScoreService;

public class TennisApplication {
    public static void main(String[] args) {
        TennisScoreService tennisScoreService = new TennisScoreService();
        TennisGameConsole tennisGameConsole = new TennisGameConsole(tennisScoreService);
        tennisGameConsole.start();
    }
}

