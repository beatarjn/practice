package string_processor;

public class MarkdownProcessor {
    public static final String PAR_START = "<p>";
    public static final String PAR_END = "</p>";
    public static final String DEL_END = "</del.>";
    public static final String DEL_START = "<del>";
    public static final String BR = "<br />";
    public static final String BLOCKQUOTE_END = "</blockquote>";
    public static final String BLOCKQUOTE_START = "<blockquote>";

//    Problem:
//    We're going to build the beginnings of a markdown processor. Markdown is a markup language that allows you to
//    easily create HTML.
//    We ll provide some sample input and desired output. Dont worry too much about edge cases, but feel free to ask
//    if you re unsure or think there s something we ought to consider.
//
//    Part 1:  A markdown processor is capable of handling a multitude of string to html tag formats. For now, we just want
//    to focus on supporting <p/>, <br/>, <blockquote/>, and <del/> tags.
//
//            Input:
//    String input = "This is a paragraph with a soft\n" + "line break.\n\n" + "This is another paragraph
//    that has\n" + "> Some text that\n" + "> is in a\n" + "> block quote.\n\n" +
//            "This is another paragraph with a ~~strikethrough~~ word.";
//
//    Expected Output:
//            "<p>This is a paragraph with a soft<br />line break.</p>
//              <p>This is another paragraph that has <br />
//              <blockquote.>Some text that<br />is in a<b.r />
//              block quote</blockquote.> </p> <p>This is another paragraph with a
//              <del>strikethrough</del.> word.</p>"


    public String process(String input) {
        StringBuilder output = new StringBuilder();

        String[] paragraphs = input.split("\n\n");
        for (String paragraph : paragraphs) {
            output.append(PAR_START);
            boolean s = paragraph.contains(">");
            if (s) {
                paragraph = paragraph.replaceFirst(">", BLOCKQUOTE_START);
            }
            paragraph = paragraph.replace("\n", BR);
            paragraph = paragraph.replaceAll("~~(.*?)~~", "<del>$1</del.>");
            paragraph = paragraph.replaceAll(">>", ">");

            output.append(paragraph);
            if (s) {
                output.append(BLOCKQUOTE_END);
            }
            output.append(PAR_END);
        }
        return output.toString();
    }

    public String processString(String input) {
        int length = input.length();
        boolean isBlockQActive = false, isDelActive = false, isParActive = true;
        StringBuilder answer = new StringBuilder();
        answer.append(PAR_START);

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);

            switch (c) {
                case '\n': {
                    char next = getNext(input, i, length);
                    if (next == '\n') {
                        if (isBlockQActive) {
                            answer.append(BLOCKQUOTE_END);
                            isBlockQActive = false;
                        }
                        answer.append(PAR_END);
                        isParActive = false;
                        i++;
                    } else {
                        answer.append(BR);
                    }
                    if (!isParActive) {
                        answer.append(PAR_START);
                        isParActive = true;
                    }
                }
                break;
                case '~': {
                    char next = getNext(input, i, length);
                    if (next == '~') {
                        if (isDelActive) {
                            answer.append(DEL_END);
                            isDelActive = false;
                        } else if (!isDelActive) {
                            answer.append(DEL_START);
                            isDelActive = true;
                        }
                        i++;
                    } else {
                        answer.append(BR);
                    }
                }
                break;
                case '>':
                    if (!isBlockQActive) {
                        answer.append(BLOCKQUOTE_START);
                        isBlockQActive = true;
                    }
                    break;
                default:
                    answer.append(c);
            }
        }
        answer.append(PAR_END);
        return answer.toString();
    }

    private static char getNext(String input, int i, int length) {
        return i + 1 < length ? input.charAt(i + 1) : ' ';
    }
}