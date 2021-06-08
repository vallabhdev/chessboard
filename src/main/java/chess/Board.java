package chess;

import java.util.Arrays;
import java.util.List;

public class Board {
    private static final int BOARD_SIZE = 8;
    public static final List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
    public static final List<String> columns = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");

    public String[][] spots;

    public Board() {
        spots = new String[BOARD_SIZE][BOARD_SIZE];
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                spots[x][y] = rows.get(x) + columns.get(y);
            }
        }
    }

    public String[][] getSpots() {
        return spots;
    }

    public int findXIndexOf(String spot) {
        return rows.indexOf(spot.split("")[0]);
    }

    public int findYIndexOf(String spot) {
        return columns.indexOf(spot.split("")[1]);
    }
}
