package chess.domain.piece.pieceTypes;

import chess.domain.piece.AbstractPiece;
import chess.domain.side.SideType;

public class King extends AbstractPiece{

    public King(SideType sideType) {
        super(sideType);
        super.pieceType = PieceType.King;
    }
}
