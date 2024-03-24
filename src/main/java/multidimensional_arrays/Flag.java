package multidimensional_arrays;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Flag {

    public String[] makeFlag(int n) {
        if (n < 0) {
            return new String[]{};
        }

        String[] arr = new String[n];

        String word = buildWord(n);

        Arrays.fill(arr, word);

        Arrays.stream(arr)
                .map(s -> s + " ")
                .forEach(System.out::println);
        return arr;
    }

    private String buildWord(int n) {
        String repeat = StringUtils.repeat("*", n);
        return new StringBuilder(repeat).append("\n").append(repeat).append("\n").append(StringUtils.repeat(" ", n)).toString();
    }
}
