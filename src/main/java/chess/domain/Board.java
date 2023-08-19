package chess.domain;

import java.util.LinkedHashMap;

import java.util.Map;

import java.util.function.Predicate;

import chess.domain.piece.Piece;
import chess.domain.piece.pieceTypes.Bishop;
import chess.domain.piece.pieceTypes.King;
import chess.domain.piece.pieceTypes.Knight;
import chess.domain.piece.pieceTypes.Pawn;
import chess.domain.piece.pieceTypes.Queen;
import chess.domain.piece.pieceTypes.Rook;
import chess.domain.side.SideType;

public class Board {

    private static Board instance;
    private final Map<Position, Piece> board;
    private static final Integer MAX_BOARD_LENGTH = 8;
    private static final Integer BLACK_SPECAIL_PIECES_ROW = 8;
    private static final Integer BLACK_PAWN_ROW = 7;
    private static final Integer WHITE_PAWN_ROW = 2;
    private static final Integer WHITE_SPECAIL_PIECES_ROW = 1;

    private Board() {
        // HashMap은 key의 순서 보장 x. LinkedHashMap은 key 순서 보장함
        board = new LinkedHashMap<>();
        initialize();
    }

    public static Board getInstance() {
        if (instance == null)
            instance = new Board();
        return instance;
    }

    public String getBoard() {
        StringBuilder result = new StringBuilder();

        int times = 1;
        for (Position position : board.keySet()) {
            Piece piece = board.get(position);
            if (piece != null)
                result.append(piece.getName());
            if (piece == null)
                result.append(".");
            if (times % 8 == 0)
                result.append("\n");
            times++;
        }
        return result.toString();
    }

    private void initialize() {
        for (int row = MAX_BOARD_LENGTH; row >= 1; row--) {
            for (char column = 'a'; column <= 'h'; column++) {
                putPieces(row, column);
            }
        }
    }

    private void putPieces(int row, char column) {
        SideType sideType = getSideTypeByRow(row);
        // put special pieces
        if (isBlackSpecialPiecesRow.test(row) || isWhiteSpecialPiecesRow.test(row)) {
            if (isRookColumn.test(column))
                board.put(new Position(column, row), new Rook(sideType));
            if (isKnightColumn.test(column))
                board.put(new Position(column, row), new Knight(sideType));
            if (isBishopColumn.test(column))
                board.put(new Position(column, row), new Bishop(sideType));
            if (isQueenColumn.test(column))
                board.put(new Position(column, row), new Queen(sideType));
            if (isKingColumn.test(column))
                board.put(new Position(column, row), new King(sideType));
            return;
        }
        // put pawns
        if (isBlackPawnRow.test(row) || isWhitePawnRow.test(row)) {
            board.put(new Position(column, row), new Pawn(sideType));
            return;
        }

        board.put(new Position(column, row), null);
    }

    private SideType getSideTypeByRow(int row) {
        if (isBlackPawnRow.test(row) || isBlackSpecialPiecesRow.test(row))
            return SideType.Black;
        if (isWhitePawnRow.test(row) || isWhiteSpecialPiecesRow.test(row))
            return SideType.White;
        return null;
    }

    private Predicate<Integer> isBlackSpecialPiecesRow = row -> row.equals(BLACK_SPECAIL_PIECES_ROW);
    private Predicate<Integer> isBlackPawnRow = row -> row.equals(BLACK_PAWN_ROW);
    private Predicate<Integer> isWhiteSpecialPiecesRow = row -> row.equals(WHITE_SPECAIL_PIECES_ROW);
    private Predicate<Integer> isWhitePawnRow = row -> row.equals(WHITE_PAWN_ROW);

    private Predicate<Character> isRookColumn = column -> column.equals('a') || column.equals('h');
    private Predicate<Character> isKnightColumn = column -> column.equals('b') || column.equals('g');
    private Predicate<Character> isBishopColumn = column -> column.equals('c') || column.equals('f');
    private Predicate<Character> isQueenColumn = column -> column.equals('d');
    private Predicate<Character> isKingColumn = column -> column.equals('e');

}
