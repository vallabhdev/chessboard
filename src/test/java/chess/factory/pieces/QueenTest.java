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

public class QueenTest {

    private Queen queen;
    private Board board;

    @Before
    public void setUp() {
        queen = new Queen();
        board = Board.getInstance();
    }

    @Test
    public void checkMovementRulesForQueen() {
        Assert.assertEquals(queen.possibleMoves(), Arrays.asList(Moves.values()));
    }

    @Test
    public void checkAllTypesOfMove() {
        String expectedSpots = "D1,D2,D3,D4,D6,D7,D8," + //horizontal of D5
                "A5,B5,C5,E5,F5,G5,H5," + //vertical of D5
                "A2,B3,C4,E6,F7,G8,A8,B7,C6,E4,F3,G2,H1"; // diagonal to D5 [(A2-G8),(H1-A8)]
        List<String> expectedMoves = Arrays.stream(expectedSpots.split(","))
                .collect(Collectors.toList());
        Set<String> suggestedMoves = queen.suggestions("D5", board);
        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void checkCornerMoves() {
        String expectedSpots = "H1,H2,H3,H4,H5,H6,H7," + //horizontal of H8
                "G8,F8,E8,D8,C8,B8,A8," + //vertical of H8
                "G7,F6,E5,D4,C3,B2,A1";  // diagonal to H8
        List<String> expectedMoves = Arrays.stream(expectedSpots.split(","))
                .collect(Collectors.toList());
        Set<String> suggestedMoves = queen.suggestions("H8", board);
        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

}