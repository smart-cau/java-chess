package chess.domain.side;

public enum SideType {
    Black, White;

    public static boolean isBlack(SideType sideType) {
        return sideType == Black;
    }
}
