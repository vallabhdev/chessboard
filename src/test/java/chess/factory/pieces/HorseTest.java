package chess.factory.pieces;

import chess.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HorseTest {
    private Horse horse;
    private Board board;

    @Before
    public void setUp() {
        horse = new Horse();
        board = Board.getInstance();
    }

    @Test
    public void checkMovementRulesForKing() {
        Assert.assertEquals(horse.possibleMoves(), Collections.emptyList());
    }

    @Test
    public void checkAllTypesOfMove() {
        String expectedSpots = "B1,D1,B5,D5," + //move horizontally first then Vertically picked spots
                "A2,A4,E2,E4"; //move vertically first then horizontally picked spots
        List<String> expectedMoves = Arrays.stream(expectedSpots.split(",")).collect(Collectors.toList());

        Set<String> suggestedMoves = horse.suggestions("C3", board);

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
    }

    @Test
    public void checkCornerMoves() {
        List<String> expectedMoves = Arrays.stream("C1,C3,B4".split(","))
                .collect(Collectors.toList());

        Set<String> suggestedMoves = horse.suggestions("A2", board);

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
    }
}