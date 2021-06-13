package chess.factory;

import chess.factory.pieces.Horse;
import chess.factory.pieces.King;
import chess.factory.pieces.Queen;
import chess.factory.pieces.Rook;
import org.junit.Assert;
import org.junit.Test;

public class PieceFactoryTest {
    @Test
    public void getKingPieceFromFactory() {
        PieceFactory pieceFactory = new PieceFactory();
        Assert.assertTrue(pieceFactory.getPieceByType("king") instanceof King);
        Assert.assertTrue(pieceFactory.getPieceByType("horse") instanceof Horse);
        Assert.assertTrue(pieceFactory.getPieceByType("queen") instanceof Queen);
        Assert.assertTrue(pieceFactory.getPieceByType("rook") instanceof Rook);
    }
}