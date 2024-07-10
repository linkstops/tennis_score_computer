package tennis.domain.commands;


import tennis.domain.models.Match;

// Interface pour les commandes
public interface Command {
    void execute(Match match);
}
