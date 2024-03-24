package multidimensional_arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FlagTest {

    private Flag flag = new Flag();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void makeFlag(String[] expected, int n) {
        String[] result = flag.makeFlag(n);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new String[]{"****\n****\n    ", "****\n****\n    ", "****\n****\n    ", "****\n****\n    " }, 4),
                Arguments.of(new String[]{"**\n**\n  ", "**\n**\n  " }, 2),
                Arguments.of(new String[]{"*\n*\n " }, 1),
                Arguments.of(new String[]{}, 0),
                Arguments.of(new String[]{}, -2)

        );
    }
}