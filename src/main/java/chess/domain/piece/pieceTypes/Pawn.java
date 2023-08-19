package chess.domain.piece.pieceTypes;

import chess.domain.piece.AbstractPiece;
import chess.domain.side.SideType;

public class Pawn extends AbstractPiece {

    public Pawn(SideType sideType) {
        super(sideType);
        super.pieceType = PieceType.Pawn;
    }
}
