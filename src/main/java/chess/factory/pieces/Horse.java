package chess.factory.pieces;

import chess.Board;
import chess.Moves;
import chess.factory.Piece;

import java.util.*;

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

        if (isValidIndex(y - 2) && isValidIndex(x - 1)) {
            collectedSpots.add(spots[x - 1][y - 2]);
        }
        if (isValidIndex(y - 2) && isValidIndex(x + 1)) {
            collectedSpots.add(spots[x + 1][y - 2]);
        }

        if (isValidIndex(y + 2) && isValidIndex(x - 1)) {
            collectedSpots.add(spots[x - 1][y + 2]);
        }
        if (isValidIndex(y + 2) && isValidIndex(x + 1)) {
            collectedSpots.add(spots[x + 1][y + 2]);
        }

        return collectedSpots;
    }

    private List<String> getVerticalFollowedByHorizontal(String spot, Board board) {
        String[][] spots = board.getSpots();
        final int x = board.findXIndexOf(spot);
        final int y = board.findYIndexOf(spot);
        List<String> collectedSpots = new ArrayList<>();

        if (isValidIndex(x - 2) && isValidIndex(y - 1)) {
            collectedSpots.add(spots[x - 2][y - 1]);
        }
        if (isValidIndex(x - 2) && isValidIndex(y + 1)) {
            collectedSpots.add(spots[x - 2][y + 1]);
        }
        if (isValidIndex(x + 2) && isValidIndex(y - 1)) {
            collectedSpots.add(spots[x + 2][y - 1]);
        }
        if (isValidIndex(x + 2) && isValidIndex(y + 1)) {
            collectedSpots.add(spots[x + 2][y + 1]);
        }
        return collectedSpots;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= 7;
    }
}
