package chess.factory.pieces;

import chess.Moves;
import chess.factory.Piece;
import chess.service.MovementService;
import chess.service.MovementServiceImpl;

import java.util.*;

public class Horse extends Piece {
    private MovementService movementService;

    public Horse() {
        movementService = new MovementServiceImpl();
    }

    @Override
    public Set<String> getSuggestions(String spot) {
        Set<String> suggestions = new HashSet<>();
        suggestions.addAll(getHorizontalFollowedByVertical(spot));
        suggestions.addAll(getVerticalFollowedByHorizontal(spot));
        return suggestions;
    }

    @Override
    public List<Moves> possibleMoves() {
        return Collections.emptyList();
    }

    @Override
    public Float maxSteps() {
        return 2.5f;
    }

    private List<String> getHorizontalFollowedByVertical(String spot) {
        List<String> collectedSpots = new ArrayList<>();
        movementService.getExactSpotsFor(spot, 2.0f, Moves.HORIZONTAL)
                .forEach(eachSpot -> collectedSpots.addAll(movementService.getAllVerticalSpotsFor(eachSpot, 1.0f)));
        return collectedSpots;
    }

    private List<String> getVerticalFollowedByHorizontal(String spot) {
        List<String> collectedSpots = new ArrayList<>();
        movementService.getExactSpotsFor(spot, 2.0f, Moves.VERTICAL)
                .forEach(eachSpot -> collectedSpots.addAll(movementService.getAllHorizontalSpotsFor(eachSpot, 1.0f)));
        return collectedSpots;
    }
}
