package chess.factory.pieces;

import chess.Board;
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
    private Board board;

    @Before
    public void setUp() {
        king = new King();
        board = Board.getInstance();
    }

    @Test
    public void checkMovementRulesForKing() {
        Assert.assertEquals(king.possibleMoves(), Arrays.asList(Moves.values()));
    }

    @Test
    public void checkAllTypesOfMove() {
        Set<String> suggestedMoves = king.suggestions("B3", board);
        List<String> expectedMoves = Arrays.stream("A2,A3,A4,B2,B4,C2,C3,C4".split(","))
                .collect(Collectors.toList());
        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
    }

    @Test
    public void checkCornerMoves() {
        Set<String> suggestedMoves = king.suggestions("A1", board);
        List<String> expectedMoves = Arrays.stream("A2,B2,B1".split(","))
                .collect(Collectors.toList());
        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
    }
}