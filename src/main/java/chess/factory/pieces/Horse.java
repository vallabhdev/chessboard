package chess.factory.pieces;

import chess.Board;
import chess.Moves;
import chess.factory.Piece;

import java.util.*;

import static chess.Board.addIfValid;

public class Horse extends Piece {
    @Override
    public Set<String> suggestions(String spot, Board board) {
        Set<String> suggestions = new HashSet<>();
        suggestions.addAll(getHorizontalFollowedByVertical(spot, board));
        suggestions.addAll(getVerticalFollowedByHorizontal(spot, board));
        return suggestions;
    }

    @Override
    public List<Moves> possibleMoves() {
        return Collections.emptyList();
    }

    private List<String> getHorizontalFollowedByVertical(String spot, Board board) {
        String[][] spots = board.getSpots();
        final int x = board.findXIndexOf(spot);
        final int y = board.findYIndexOf(spot);
        List<String> collectedSpots = new ArrayList<>();

        addIfValid(spots, x - 1, y - 2, collectedSpots);
        addIfValid(spots, x + 1, y - 2, collectedSpots);
        addIfValid(spots, x - 1, y + 2, collectedSpots);
        addIfValid(spots, x + 1, y + 2, collectedSpots);
        return collectedSpots;
    }

    private List<String> getVerticalFollowedByHorizontal(String spot, Board board) {
        String[][] spots = board.getSpots();
        final int x = board.findXIndexOf(spot);
        final int y = board.findYIndexOf(spot);
        List<String> collectedSpots = new ArrayList<>();

        addIfValid(spots, x - 2, y - 1, collectedSpots);
        addIfValid(spots, x - 2, y + 1, collectedSpots);
        addIfValid(spots, x + 2, y - 1, collectedSpots);
        addIfValid(spots, x + 2, y + 1, collectedSpots);
        return collectedSpots;
    }
}
