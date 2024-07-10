package tennis.application;


import tennis.domain.services.TennisScoreService;
import java.util.Scanner;


public class TennisGameConsole {
    private final TennisScoreService tennisScoreService;

    public TennisGameConsole(TennisScoreService tennisScoreService) {
        this.tennisScoreService = tennisScoreService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the points sequence (exemple : 'AAABBBABBABB') or 'exit' to quit:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                tennisScoreService.resetMatch(); // Reset the match before processing new points
                tennisScoreService.processPoints(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
