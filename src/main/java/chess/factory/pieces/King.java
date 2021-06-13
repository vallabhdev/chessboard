package chess.factory.pieces;

import chess.Moves;
import chess.factory.Piece;
import chess.service.MovementService;
import chess.service.MovementServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static chess.Moves.*;

public class King extends Piece {
    private MovementService movementService;

    public King() {
        movementService = new MovementServiceImpl();
    }

    @Override
    public Set<String> getSuggestions(String spot) {
        Set<String> suggestions = new HashSet<>();
        possibleMoves().forEach(move -> suggestions.addAll(getNextPosFor(spot, move)));
        return suggestions;
    }

    @Override
    public List<Moves> possibleMoves() {
        return Arrays.asList(VERTICAL, HORIZONTAL, DIAGONAL);
    }

    @Override
    public Float maxSteps() {
        return 1.0f;
    }

    private List<String> getNextPosFor(String spot, Moves move) {
        switch (move) {
            case HORIZONTAL:
                return movementService.getAllHorizontalSpotsFor(spot, maxSteps());
            case VERTICAL:
                return movementService.getAllVerticalSpotsFor(spot, maxSteps());
            case DIAGONAL:
                return movementService.getAllDiagonalSpotsFor(spot, maxSteps());
            default:
                break;
        }
        return null;
    }
}
