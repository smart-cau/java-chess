package chess.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void position_생성시_예외처리() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position('a', 0);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position('i', 1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position('a', 9);
        });
    }

    @Test
    void equals() {
        Position a = new Position('a', 1);
        Position a1 = new Position('a', 1);

        assertThat(a).isEqualTo(a1);
        assertThat(a.hashCode()).isEqualTo(a1.hashCode());
    }
}
