package chess.factory;

import chess.factory.pieces.Horse;
import chess.factory.pieces.King;
import chess.factory.pieces.Queen;

public class PieceFactory {

    public Piece getPieceByType(String type) {
        switch (type) {
            case "king":
                return new King();
            case "horse":
                return new Horse();
            case "queen":
                return new Queen();
        }
        return null;
    }
}
