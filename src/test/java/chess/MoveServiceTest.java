package chess;

import chess.factory.pieces.King;
import chess.factory.pieces.Queen;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoveServiceTest {
    private static MoveService moveService;
    private static King king;
    private static Queen queen;

    @BeforeClass
    public static void setUp() {
        moveService = new MoveService();
        king = new King();
        queen = new Queen();
    }

    @Test
    public void checkHorizontalMoveForKing() {
        List<String> expectedMoves = Arrays.stream("D4,D6".split(","))
                .collect(Collectors.toList());

        List<String> suggestedMoves = moveService
                .getAllHorizontalSpotsFor("D5", king.maxSteps());

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void checkHorizontalMoveForQueen() {
        String expectedSpots = "D1,D2,D3,D4,D6,D7,D8"; //horizontal of D5
        List<String> expectedMoves = Arrays.stream(expectedSpots.split(","))
                .collect(Collectors.toList());

        List<String> suggestedMoves = moveService.getAllHorizontalSpotsFor("D5", queen.maxSteps());

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void checkVerticalMoveForKing() {
        List<String> expectedMoves = Arrays.stream("C5,E5".split(","))
                .collect(Collectors.toList());

        List<String> suggestedMoves = moveService
                .getAllVerticalSpotsFor("D5", king.maxSteps());

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void checkVerticalMoveForQueue() {
        String expectedSpots = "A5,B5,C5,E5,F5,G5,H5,"; //vertical of D5
        List<String> expectedMoves = Arrays.stream(expectedSpots.split(","))
                .collect(Collectors.toList());

        List<String> suggestedMoves = moveService.getAllVerticalSpotsFor("D5", queen.maxSteps());

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void checkDiagonalMoveForKing() {
        List<String> expectedMoves = Arrays.stream("A2,A4,C2,C4".split(","))
                .collect(Collectors.toList());

        List<String> suggestedMoves = moveService.getAllDiagonalSpotsFor("B3", king.maxSteps());

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }

    @Test
    public void checkDiagonalMoveForQueen() {
        List<String> expectedMoves = Arrays.stream("A2,B3,C4,E6,F7,G8,A8,B7,C6,E4,F3,G2,H1".split(","))
                .collect(Collectors.toList());

        List<String> suggestedMoves = moveService.getAllDiagonalSpotsFor("D5", queen.maxSteps());

        Assert.assertTrue(expectedMoves.containsAll(suggestedMoves));
        Assert.assertTrue(suggestedMoves.containsAll(expectedMoves));
    }
}