package chess.domain;

import org.junit.jupiter.api.Test;

import chess.domain.piece.Piece;
import chess.domain.piece.pieceTypes.Rook;
import chess.domain.side.SideType;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    Piece blackPawn = Fixture.BLACK_PAWN;
    Piece whitePawn = Fixture.WHITE_PAWN;

    @Test
    void piece_name() {
        assertThat(blackPawn.getName().equals("P"));
        assertThat(whitePawn.getName().equals("P"));
    }

    @Test
    void equals() {
        Piece blackRook = new Rook(SideType.Black);
        Piece otherBlackRook = new Rook(SideType.Black);

        assertThat(blackRook).isEqualTo(otherBlackRook);
        assertThat(blackRook.hashCode()).isEqualTo(otherBlackRook.hashCode());

        assertThat(blackPawn.equals(whitePawn)).isFalse();
    }
}
