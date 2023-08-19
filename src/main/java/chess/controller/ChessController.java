package chess.controller;

import chess.domain.Board;
import chess.view.OutputView;

public class ChessController {
    public static void main(String[] args) {
        Board board = Board.getInstance();
        OutputView.gameStart();
        OutputView.printBoard(board);
    }
}
