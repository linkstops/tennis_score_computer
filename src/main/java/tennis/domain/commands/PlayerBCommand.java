package tennis.domain.commands;


import tennis.domain.models.Match;

// Commande pour gérer le point gagné par le joueur B
public class PlayerBCommand implements Command {
    @Override
    public void execute(Match match) {
        match.pointWonBy("Player B");
    }
}
