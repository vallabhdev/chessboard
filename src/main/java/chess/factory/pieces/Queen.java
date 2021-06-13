package chess.factory.pieces;

import chess.Board;
import chess.Moves;
import chess.factory.Piece;

import java.util.*;

import static chess.Board.addIfValid;
import static chess.Moves.*;

public class Queen extends Piece {
    @Override
    public Set<String> suggestions(String spot, Board board) {
        Set<String> suggestions = new HashSet<>();
        possibleMoves().forEach(move -> suggestions.addAll(getNextPosFor(spot, move, board)));
        suggestions.remove(spot);
        return suggestions;
    }

    @Override
    public List<Moves> possibleMoves() {
        return Arrays.asList(VERTICAL, HORIZONTAL, DIAGONAL);
    }

    @Override
    public Float maxSteps() {
        return 7.0f;
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
        int currentRow = board.findXIndexOf(spot);
        // queen can walk any steps horizontally in current row, so adding all the current row spots.
        return Arrays.asList(spots[currentRow]);
    }

    private List<String> getAllVerticalSpotsFor(String spot, Board board) {
        String[][] spots = board.getSpots();
        int currentCol = board.findYIndexOf(spot);
        List<String> verticalSpots = new ArrayList<>();
        // queen can walk any steps vertically from current row's spot, so adding all the current column spots.
        for (int x = 0; x < 8; x++) {
            verticalSpots.add(spots[x][currentCol]);
        }
        return verticalSpots;
    }

    private List<String> getAllDiagonalSpotsFor(String spot, Board board) {
        String[][] spots = board.getSpots();
        List<String> diagonalSpots = new ArrayList<>();
        final int x = board.findXIndexOf(spot);
        final int y = board.findYIndexOf(spot);
        for (int i = 1; i < 8; i++) {
            addIfValid(spots, x + i, y + i, diagonalSpots);
            addIfValid(spots, x - i, y + i, diagonalSpots);
            addIfValid(spots, x - i, y - i, diagonalSpots);
            addIfValid(spots, x + i, y - i, diagonalSpots);
        }
        return diagonalSpots;
    }
}
