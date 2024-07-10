package tennis;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tennis.domain.services.TennisScoreService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TennisScoreTest {
    private TennisScoreService tennisScoreService;

    @BeforeEach
    public void setUp() {
        tennisScoreService = new TennisScoreService();
    }

    @Test
    public void testInitialScore() {
        assertEquals("Player A: 0 -- Player B: 0", tennisScoreService.getMatch().getCurrentScore());
    }

    @Test
    public void testPlayerAWins() {
        tennisScoreService.processPoints("AAAA");
        assertEquals("Player A wins the game", tennisScoreService.getMatch().getFinalScore());
    }

    @Test
    public void testPlayerBWins() {
        tennisScoreService.processPoints("BBBB");
        assertEquals("Player B wins the game", tennisScoreService.getMatch().getFinalScore());
    }

    @Test
    public void testDeuce() {
        tennisScoreService.processPoints("ABABABAB");
        assertEquals("Player A: 40 -- Player B: 40 -- Deuce", tennisScoreService.getMatch().getCurrentScore());
    }

    @Test
    public void testAdvantage() {
        tennisScoreService.processPoints("ABABABABA");
        assertEquals("Player A: Advantage -- Player B: 40", tennisScoreService.getMatch().getCurrentScore());
    }

    @Test
    public void testInvalidInput() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            tennisScoreService.processPoints("ABAC");
        });
        assertEquals("Invalid input: C", thrown.getMessage());
    }

    @Test
    public void testExtraPointsAfterWin() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            tennisScoreService.processPoints("AAAAA");
        });
        assertEquals("The game has already been won. Extra points in input sequence.", thrown.getMessage());
    }
}
