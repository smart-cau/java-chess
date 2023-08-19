package chess.domain.piece.pieceTypes;

import chess.domain.piece.AbstractPiece;
import chess.domain.side.SideType;

public class Rook extends AbstractPiece {

    public Rook(SideType sideType) {
        super(sideType);
        super.pieceType = PieceType.Rook;
    }
}
