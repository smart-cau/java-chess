package chess.domain.piece.pieceTypes;

import chess.domain.piece.AbstractPiece;
import chess.domain.side.SideType;

public class Knight extends AbstractPiece{

    public Knight(SideType sideType) {
        super(sideType);
        super.pieceType = PieceType.Knight;
    }
}
