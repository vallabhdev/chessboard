package chess.service;

import chess.Board;
import chess.Moves;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static chess.Board.addIfValid;
import static chess.Board.getInstance;

public class MovementServiceImpl implements MovementService {
    private Board board;

    public MovementServiceImpl() {
        board = getInstance();
    }

    public List<String> getExactSpotsFor(String spot, Float exactStep, Moves moves) {
        final int row = board.findXIndexOf(spot);
        final int col = board.findYIndexOf(spot);
        switch (moves) {
            case HORIZONTAL:
                return horizontalOnes(row, col, exactStep);
            case VERTICAL:
                return verticalOnes(row, col, exactStep);
            case DIAGONAL:
                return diagonalOnes(row, col, exactStep);
            default:
                break;
        }
        return Collections.emptyList();
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

    private List<String> horizontalOnes(int row, int col, Float exactStep) {
        List<String> horizontalSpots = new ArrayList<>();
        int i = exactStep.intValue();
        addIfValid(row, col - i, horizontalSpots);
        addIfValid(row, col + i, horizontalSpots);
        return horizontalSpots;
    }

    private List<String> verticalOnes(int row, int col, Float exactStep) {
        List<String> verticalSpots = new ArrayList<>();
        int i = exactStep.intValue();
        addIfValid(row + i, col, verticalSpots);
        addIfValid(row - i, col, verticalSpots);
        return verticalSpots;
    }

    private List<String> diagonalOnes(int row, int col, Float exactStep) {
        List<String> diagonalSpots = new ArrayList<>();
        int i = exactStep.intValue();
        addIfValid(row + i, col + i, diagonalSpots);
        addIfValid(row - i, col + i, diagonalSpots);
        addIfValid(row - i, col - i, diagonalSpots);
        addIfValid(row + i, col - i, diagonalSpots);
        return diagonalSpots;
    }
}
