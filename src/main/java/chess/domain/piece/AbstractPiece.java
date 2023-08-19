package chess.domain.piece;

import java.util.Objects;

import chess.domain.piece.pieceTypes.PieceType;
import chess.domain.side.SideType;

public abstract class AbstractPiece implements Piece {

    protected final SideType sideType;
    protected PieceType pieceType;

    public AbstractPiece(SideType sideType) {
        this.sideType = sideType;
    }

    public String getName() {
        return pieceType.getName(sideType);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AbstractPiece other = (AbstractPiece) o;

        return sideType == other.sideType && pieceType == other.pieceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideType, pieceType);
    }
}
