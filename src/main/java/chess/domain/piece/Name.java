package chess.domain.piece;

import java.util.function.Predicate;

import chess.domain.side.SideType;

public class Name {
    private final String name;

    public Name(String name) {
        if (isInvalidName.test(name))
            throw new IllegalArgumentException();
        this.name = name;
    }

    public String getName(SideType sideType) {
        if (SideType.isBlack(sideType))
            return name.toUpperCase();
        return name.toLowerCase();
    }

    private Predicate<String> isInvalidName = str -> str == null || str.isEmpty() || str.length() != 1;
    
}
