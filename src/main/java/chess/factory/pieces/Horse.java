package chess.factory.pieces;

import chess.Board;
import chess.Moves;
import chess.factory.Piece;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static chess.Moves.HORIZONTAL;
import static chess.Moves.VERTICAL;

public class Horse extends Piece {
    @Override
    public Set<String> suggestions(String spot, Board board) {
        return null;
    }

    @Override
    public List<Moves> possibleMoves() {
        return Arrays.asList(VERTICAL, HORIZONTAL);
    }
}
