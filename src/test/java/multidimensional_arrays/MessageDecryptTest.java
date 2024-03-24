package multidimensional_arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageDecryptTest {

    private MessageDecrypt messageDecrypt = new MessageDecrypt();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void showDiagonal(String expected, int[] n) {
        String[] result = messageDecrypt.decipherMessage(n);
        String joined = String.join("", result);
        assertEquals(expected, joined);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("youCanCode", new int[]{121, 111, 117, 67, 97, 110, 67, 111, 100, 101}),
                Arguments.of("youRock<3", new int[]{121, 111, 117, 82, 111, 99, 107, 60, 51}),
                Arguments.of("CanYouDoIT?", new int[]{67, 97, 110, 89, 111, 117, 68, 111, 73, 84, 63})
        );
    }
}