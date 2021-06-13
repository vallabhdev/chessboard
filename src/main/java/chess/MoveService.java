package chess;

import java.util.ArrayList;
import java.util.List;

import static chess.Board.getInstance;
import static chess.Board.isValidIndex;

public class MoveService {
    private Board board;
    private String[][] spots;

    public MoveService() {
        board = getInstance();
        spots = board.getSpots();
    }

    public List<String> getAllHorizontalSpotsFor(String spot, Float maxSteps) {
        final int row = board.findXIndexOf(spot);
        final int col = board.findYIndexOf(spot);
        List<String> horizontalSpots = new ArrayList<>();

        for (int i = 1; i <= maxSteps; i++) {
            addIfValid(row, col - i, horizontalSpots);
            addIfValid(row, col + i, horizontalSpots);
        }
        return horizontalSpots;
    }

    public List<String> getAllVerticalSpotsFor(String spot, Float maxSteps) {
        final int row = board.findXIndexOf(spot);
        final int col = board.findYIndexOf(spot);
        List<String> verticalSpots = new ArrayList<>();

        for (int i = 1; i <= maxSteps; i++) {
            addIfValid(row + i, col, verticalSpots);
            addIfValid(row - i, col, verticalSpots);
        }
        return verticalSpots;
    }

    public List<String> getAllDiagonalSpotsFor(String spot, Float maxSteps) {
        final int row = board.findXIndexOf(spot);
        final int col = board.findYIndexOf(spot);
        List<String> diagonalSpots = new ArrayList<>();

        for (int i = 1; i <= maxSteps; i++) {
            addIfValid(row + i, col + i, diagonalSpots);
            addIfValid(row - i, col + i, diagonalSpots);
            addIfValid(row - i, col - i, diagonalSpots);
            addIfValid(row + i, col - i, diagonalSpots);
        }
        return diagonalSpots;
    }

    private void addIfValid(int row, int col, List<String> collectedSpots) {
        if (isValidIndex(row) && isValidIndex(col)) {
            collectedSpots.add(spots[row][col]);
        }
    }
}
