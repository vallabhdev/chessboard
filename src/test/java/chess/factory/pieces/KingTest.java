package chess.factory.pieces;

import chess.Moves;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class KingTest {
    private King king;

    @Before
    public void setUp() {
        king = new King();
    }

    @Test
    public void checkMovementRulesForKing() {
        Assert.assertEquals(king.possibleMoves(), Arrays.asList(Moves.values()));
    }

    @Test
    public void checkAllTypesOfMove() {
        List<String> expectedMoves = Arrays.stream("A2,A3,A4,B2,B4,C2,C3,C4".split(","))
                .collect(Collectors.toList());

        Set<String> suggestedMoves = king.getSuggestions("B3");

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void checkCornerMoves() {
        List<String> expectedMoves = Arrays.stream("A2,B2,B1".split(","))
                .collect(Collectors.toList());

        Set<String> suggestedMoves = king.getSuggestions("A1");

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }
}