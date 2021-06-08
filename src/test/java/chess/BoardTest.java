package chess;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = Board.getInstance();
    }

    @Test
    public void initializeBoard() {
        String[][] spots = board.getSpots();
        Assert.assertThat(spots.length, Is.is(8));
        Assert.assertThat(spots[2][2], Is.is("C3"));
        Assert.assertThat(spots[7][3], Is.is("H4"));
    }
}