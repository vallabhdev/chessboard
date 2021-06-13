package chess.service;

import chess.Moves;

import java.util.List;

public interface MovementService {
    List<String> getExactSpotsFor(String spot, Float exactStep, Moves moves);

    List<String> getAllHorizontalSpotsFor(String spot, Float maxSteps);

    List<String> getAllVerticalSpotsFor(String spot, Float maxSteps);

    List<String> getAllDiagonalSpotsFor(String spot, Float maxSteps);
}
