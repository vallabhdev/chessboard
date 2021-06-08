package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimulatorTest {
    private Simulator simulator;

    @Before
    public void setUp() {
        simulator = new Simulator();
    }

    @Test
    public void kingCanMoveOneStepAnyWhere() {
        String immediateNextSpots = "E5,E6,D6,C6,C5,C4,D4,E4";
        List<String> expectedMoves = Arrays.stream(immediateNextSpots.split(",")).collect(Collectors.toList());

        Set<String> suggestedMoves = simulator.moveSuggestions("King D5");

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void whenQueenIsAtB1() {
        String expectedSpots = "B2,B3,B4,B5,B6,B7,B8," + //horizontal spots
                "A1,C1,D1,E1,F1,G1,H1," + //vertical spots
                "A2,C2,D3,E4,F5,G6,H7"; //diagonal spots
        List<String> expectedMoves = Arrays.stream(expectedSpots.split(",")).collect(Collectors.toList());

        Set<String> suggestedMoves = simulator.moveSuggestions("queen B1");

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }
}