import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Array1Test {
    @ParameterizedTest
    @NullAndEmptySource

    void shouldThrowRuntimeExceptionWhenArrayIsEmpty(int[] values) {
        Assertions.assertThrows(RuntimeException.class, () -> Array1.findAfterFour(values));

    }

    @Test
    void shouldThrowRuntimeExceptionWhenFourNotFound() {
        Assertions.assertThrows(RuntimeException.class, () -> Array1.findAfterFour(new int[] {1,3}));

    }

    @Test
    void shouldReturnValuesAfterLastFour() {
        Assertions.assertArrayEquals(
                new int[] {1, 7},
                Array1.findAfterFour(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

}
