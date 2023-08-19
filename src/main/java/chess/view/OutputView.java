package chess.view;

import chess.domain.Board;

public class OutputView {
    public static void gameStart() {
        printNewLine();
        System.out.println("체스 게임을 시작합니다.");
        printNewLine();
    }

    public static void printBoard(Board board) {
        System.out.println(board.getBoard());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }
}
