package chess.factory;

import chess.Board;
import chess.Moves;

import java.util.List;
import java.util.Set;

public abstract class Piece {
    public abstract Set<String> suggestions(String spot, Board board);

    public abstract List<Moves> possibleMoves();

    public abstract Float maxSteps();
}
