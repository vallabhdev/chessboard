package chess.factory.pieces;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static chess.Moves.HORIZONTAL;
import static chess.Moves.VERTICAL;

public class RookTest {
    private Rook rook;

    @Before
    public void setUp() {
        rook = new Rook();
    }

    @Test
    public void checkMovementRulesOfRook() {
        Assert.assertEquals(rook.possibleMoves(), Arrays.asList(VERTICAL, HORIZONTAL));
        Assert.assertThat(rook.maxSteps(), Is.is(7.0f));
    }

    @Test
    public void checkAllTypesOfMove() {
        String expectedSpots = "D1,D2,D3,D4,D6,D7,D8," + //horizontal of D5
                "A5,B5,C5,E5,F5,G5,H5,"; //vertical of D5
        List<String> expectedMoves = Arrays.stream(expectedSpots.split(","))
                .collect(Collectors.toList());

        Set<String> suggestedMoves = rook.getSuggestions("D5");

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void checkCornerMoves() {
        String expectedSpots = "H1,H2,H3,H4,H5,H6,H7," + //horizontal of H8
                "G8,F8,E8,D8,C8,B8,A8,"; //vertical of H8
        List<String> expectedMoves = Arrays.stream(expectedSpots.split(","))
                .collect(Collectors.toList());

        Set<String> suggestedMoves = rook.getSuggestions("H8");

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }
}