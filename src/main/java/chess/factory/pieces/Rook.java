package chess.factory.pieces;

import chess.Moves;
import chess.factory.Piece;
import chess.service.MovementService;
import chess.service.MovementServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static chess.Moves.HORIZONTAL;
import static chess.Moves.VERTICAL;

public class Rook extends Piece {
    private MovementService movementService;

    public Rook() {
        movementService = new MovementServiceImpl();
    }

    @Override
    public Set<String> getSuggestions(String spot) {
        Set<String> suggestions = new HashSet<>();
        possibleMoves().forEach(move -> suggestions.addAll(getNextPosFor(spot, move)));
        suggestions.remove(spot);
        return suggestions;
    }

    @Override
    public List<Moves> possibleMoves() {
        return Arrays.asList(VERTICAL, HORIZONTAL);
    }

    @Override
    public Float maxSteps() {
        return 7.0f;
    }

    private List<String> getNextPosFor(String spot, Moves move) {
        switch (move) {
            case HORIZONTAL:
                return movementService.getAllHorizontalSpotsFor(spot, maxSteps());
            case VERTICAL:
                return movementService.getAllVerticalSpotsFor(spot, maxSteps());
            case DIAGONAL:
                throw new IllegalArgumentException(this.getClass() + " can not move to" + move.name());
            default:
                break;
        }
        return null;
    }
}
