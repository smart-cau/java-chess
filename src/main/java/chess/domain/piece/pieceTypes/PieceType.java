package chess.domain.piece.pieceTypes;

import chess.domain.side.SideType;

public enum PieceType {
    Pawn("p"), Rook("r"), Knight("n"), Bishop("b"), Queen("q"), King("k");

    private final String name;
    
    PieceType(String name) {
        this.name = name;
    }

    public String getName(SideType sideType) {
        if (SideType.isBlack(sideType))
            return name.toUpperCase();
        return name.toLowerCase();
    }
}
