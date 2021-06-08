package chess.factory.pieces;

import chess.Board;
import chess.Moves;
import chess.factory.Piece;

import java.util.*;

import static chess.Moves.*;

public class King extends Piece {
    @Override
    public Set<String> suggestions(String spot, Board board) {
        Set<String> suggestions = new HashSet<>();
        possibleMoves().forEach(move -> suggestions.addAll(getNextPosFor(spot, move, board)));
        return suggestions;
    }

    @Override
    public List<Moves> possibleMoves() {
        return Arrays.asList(VERTICAL, HORIZONTAL, DIAGONAL);
    }

    private List<String> getNextPosFor(String spot, Moves move, Board board) {
        switch (move) {
            case HORIZONTAL:
                return getAllHorizontalSpotsFor(spot, board);
            case VERTICAL:
                return getAllVerticalSpotsFor(spot, board);
            case DIAGONAL:
                return getAllDiagonalSpotsFor(spot, board);
            default:
                break;
        }
        return null;
    }

    private List<String> getAllHorizontalSpotsFor(String spot, Board board) {
        String[][] spots = board.getSpots();
        final int x = board.findXIndexOf(spot);
        final int y = board.findYIndexOf(spot);
        List<String> horizontalSpots = new ArrayList<>();
        if (isValidIndex(x)) {
            if (isValidIndex(y - 1)) {
                horizontalSpots.add(spots[x][y - 1]);
            }
            if (isValidIndex(y + 1)) {
                horizontalSpots.add(spots[x][y + 1]);
            }
        }
        return horizontalSpots;
    }

    private List<String> getAllVerticalSpotsFor(String spot, Board board) {
        String[][] spots = board.getSpots();
        final int x = board.findXIndexOf(spot);
        final int y = board.findYIndexOf(spot);
        List<String> verticalSpots = new ArrayList<>();
        if (isValidIndex(y)) {
            if (isValidIndex(x + 1)) {
                verticalSpots.add(spots[x + 1][y]);
            }
            if (isValidIndex(x - 1)) {
                verticalSpots.add(spots[x - 1][y]);
            }
        }
        return verticalSpots;
    }

    private List<String> getAllDiagonalSpotsFor(String spot, Board board) {
        String[][] spots = board.getSpots();
        final int x = board.findXIndexOf(spot);
        final int y = board.findYIndexOf(spot);
        List<String> diagonalSpots = new ArrayList<>();

        if (isValidIndex(x + 1) && isValidIndex(y - 1)) {
            diagonalSpots.add(spots[x + 1][y - 1]);
        }
        if (isValidIndex(x - 1) && isValidIndex(y - 1)) {
            diagonalSpots.add(spots[x - 1][y - 1]);
        }
        if (isValidIndex(x + 1) && isValidIndex(y + 1)) {
            diagonalSpots.add(spots[x + 1][y + 1]);
        }
        if (isValidIndex(x - 1) && isValidIndex(y + 1)) {
            diagonalSpots.add(spots[x - 1][y + 1]);
        }
        return diagonalSpots;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= 7;
    }
}
