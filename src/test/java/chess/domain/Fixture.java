package chess.domain;

import chess.domain.piece.Piece;
import chess.domain.piece.pieceTypes.Pawn;
import chess.domain.side.SideType;

public class Fixture {
    public static final Position EXAMPLE_POSITION = new Position('a', 7);
    public static final Piece BLACK_PAWN = new Pawn(SideType.Black);
    public static final Piece WHITE_PAWN = new Pawn(SideType.White);
}
