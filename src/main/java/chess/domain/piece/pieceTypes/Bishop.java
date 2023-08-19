package chess.domain.piece.pieceTypes;

import chess.domain.piece.AbstractPiece;
import chess.domain.side.SideType;

public class Bishop extends AbstractPiece {

    public Bishop(SideType sideType) {
        super(sideType);
        super.pieceType = PieceType.Bishop;
    }
}
