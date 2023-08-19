package chess.domain;

public class Position {

    private final char column;
    private final Integer row;

    private final static int ROW_MIN = 1;
    private final static int ROW_MAX = 8;
    private final static char COLUMN_MIN = 'a';
    private final static char COLUMN_MAX = 'h';

    public Position(char column, int row) {
        if (isIllegalArgements(row, column))
            throw new IllegalArgumentException();

        this.column = column;
        this.row = row;
    }

    private boolean isIllegalArgements(int row, char column) {
        return isRowOutOfRange(row) || isColumnOutOfRange(column);
    }

    private boolean isRowOutOfRange(int row) {
        return ROW_MIN > row || row > ROW_MAX;
    }

    private boolean isColumnOutOfRange(char column) {
        return COLUMN_MIN > column || column > COLUMN_MAX;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position other = (Position) o;

        return other.row == this.row && other.column == this.column;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        int prime = 31;
        hash = hash * prime * row * column;
        return hash;
    }

    @Override
    public String toString() {
        return String.valueOf(column) + String.valueOf(row);
    }

}
