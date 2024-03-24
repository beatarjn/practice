package multidimensional_arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StarsDiagonalTest {

    private StarsDiagonal starsDiagonal = new StarsDiagonal();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void showDiagonal(int n, String[] expected) {
        String[] result = starsDiagonal.showDiagonal(n);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(4, new String[]{"*   *", " * * ", "  *  ", " * * ", "*   *" }),
                Arguments.of(2, new String[]{"* *", " * ", "* *" }),
                Arguments.of(0, new String[]{"*"}),
                Arguments.of(-2, new String[]{})
        );
    }
}