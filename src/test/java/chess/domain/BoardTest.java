package chess.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    Board board;
    String emptyBoard = setEmptyBoard(8);

    @BeforeEach
    void setup() {
        board = Board.getInstance();
    }

    @Test
    void initialized_boardStatus() {
        assertThat(board.getBoard().equals(initializedBoardStatus())).isTrue();
    }

    String setEmptyBoard(int emptyLines) {
        StringBuilder sb = new StringBuilder();
        String emptyLine = "........\n";

        for (int i = 0; i < emptyLines; i++) {
            sb.append(emptyLine);
        }

        return sb.toString();
    }

    String initializedBoardStatus() {
        StringBuilder sb = new StringBuilder();
        String specialPieces = "rnbqkbnr\n";
        String pawns = "pppppppp\n";
        sb.append(specialPieces.toUpperCase());
        sb.append(pawns.toUpperCase());
        sb.append(setEmptyBoard(4));
        sb.append(pawns);
        sb.append(specialPieces);
        return sb.toString();
    }
}
