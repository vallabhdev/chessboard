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

public class HorseTest {
    private Horse horse;

    @Before
    public void setUp() {
        horse = new Horse();
    }

    @Test
    public void checkMovementRulesForHorse() {
        Assert.assertEquals(horse.possibleMoves(), Arrays.asList(VERTICAL, HORIZONTAL));
        Assert.assertThat(horse.maxSteps(), Is.is(2.5f));
    }

    @Test
    public void checkAllTypesOfMove() {
        String expectedSpots = "B1,D1,B5,D5," + //move horizontally first then Vertically picked spots
                "A2,A4,E2,E4"; //move vertically first then horizontally picked spots
        List<String> expectedMoves = Arrays.stream(expectedSpots.split(",")).collect(Collectors.toList());

        Set<String> suggestedMoves = horse.getSuggestions("C3");

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void checkCornerMoves() {
        List<String> expectedMoves = Arrays.stream("C1,C3,B4".split(","))
                .collect(Collectors.toList());

        Set<String> suggestedMoves = horse.getSuggestions("A2");

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }
}