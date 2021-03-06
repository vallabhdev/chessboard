package chess.factory;

import chess.Moves;

import java.util.List;
import java.util.Set;

public abstract class Piece {
    public abstract Set<String> getSuggestions(String spot);

    public abstract List<Moves> possibleMoves();

    public abstract Float maxSteps();
}
