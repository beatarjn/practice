package string_processor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarkdownProcessorTest {

    private final MarkdownProcessor markdownProcessor = new MarkdownProcessor();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void shouldProcessString(String input, String expected) {
        String output = markdownProcessor.processString(input);

        assertEquals(expected, output);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void shouldProcess(String input, String expected) {
        String output = markdownProcessor.process(input);

        assertEquals(expected, output);
    }

    private static Stream<Arguments> provideTestData() {
        String input1 = "This is a paragraph with a soft\n" + "line break.\n\n" + "This is another paragraph that has\n" +
                "> Some text that\n" + "> is in a\n" + "> block quote.\n\n" +
                "This is another paragraph with a ~~strikethrough~~ word.";
        String expected1 = "<p>This is a paragraph with a soft<br />line break.</p><p>This is another paragraph that has<br " +
                "/><blockquote> Some text that<br /> is in a<br /> block quote.</blockquote></p><p>This is another paragraph " +
                "with a <del>strikethrough</del.> word.</p>";

        String input2 = "This is the first paragraph with a soft\nline break.\n\n" +
                "This is the second paragraph with another\nsoft line break.\n\n" +
                "This is the third paragraph.";

        String expected2 = "<p>This is the first paragraph with a soft<br />line break.</p>" +
                "<p>This is the second paragraph with another<br />soft line break.</p>" +
                "<p>This is the third paragraph.</p>";

        String input3 = "This is a paragraph with a ~~strikethrough~~ word.\n\n" +
                "Another paragraph with a\nsoft line break.";

        String expected3 = "<p>This is a paragraph with a <del>strikethrough</del.> word.</p>" +
                "<p>Another paragraph with a<br />soft line break.</p>";

        return Stream.of(
                Arguments.of(input1, expected1),
                Arguments.of(input2, expected2),
                Arguments.of(input3, expected3)
        );
    }
}