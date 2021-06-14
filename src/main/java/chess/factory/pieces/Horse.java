package chess.factory.pieces;

import chess.Moves;
import chess.factory.Piece;
import chess.service.MovementService;
import chess.service.MovementServiceImpl;

import java.util.*;

import static chess.Moves.HORIZONTAL;
import static chess.Moves.VERTICAL;

public class Horse extends Piece {
    private MovementService movementService;

    public Horse() {
        movementService = new MovementServiceImpl();
    }

    @Override
    public Set<String> getSuggestions(String spot) {
        Set<String> suggestions;
        float step = maxSteps();
        int x = (int) (step);
        float y = step % 1 < 1 && step % 1 > 0 ? 1f : 0f;
        if (y != 0f) {
            suggestions = new HashSet<>(getByMultiDirectionalMove(spot, (float) x, y));
        } else {
            throw new IllegalStateException("Horse can not move only in one direction");
        }
        return suggestions;
    }

    @Override
    public List<Moves> possibleMoves() {
        return Arrays.asList(VERTICAL, HORIZONTAL);
    }

    @Override
    public Float maxSteps() {
        return 2.5f;
    }

    private List<String> getByMultiDirectionalMove(String spot, Float x, Float y) {
        List<String> collectedSpots = new ArrayList<>();
        List<Moves> moves = possibleMoves();
        moves.forEach(m -> {
            movementService.getExactSpotsFor(spot, x, moves.get(0))
                    .forEach(eachSpot -> collectedSpots.addAll(movementService.getExactSpotsFor(eachSpot, y, moves.get(1))));
            movementService.getExactSpotsFor(spot, x, moves.get(1))
                    .forEach(eachSpot -> collectedSpots.addAll(movementService.getExactSpotsFor(eachSpot, y, moves.get(0))));
        });
        return collectedSpots;
    }
}
