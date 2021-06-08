package chess;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimulatorTest {
    @Test
    public void kingCanMoveOneStepAnyWhere() {
        Set<String> suggestedMoves = new Simulator().moveSuggestions("King D5");
        List<String> expectedMoves = Arrays.stream("E5,E6,D6,C6,C5,C4,D4,E4".split(","))
                .collect(Collectors.toList());
        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void whenQueenIsAtB1() {
        Set<String> suggestedMoves = new Simulator().moveSuggestions("Queen B1");
        List<String> expectedMoves = Arrays.stream("B2,B3,B4,B5,B6,B7,B8,A1,C1,D1,E1,F1,G1,H1".split(","))
                .collect(Collectors.toList());
        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }
}