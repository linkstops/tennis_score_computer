package tennis.domain.commands;


import tennis.domain.models.Match;

// Commande pour gérer le point gagné par le joueur A
public class PlayerACommand implements Command {
    @Override
    public void execute(Match match) {
        match.pointWonBy("Player A");
    }
}
