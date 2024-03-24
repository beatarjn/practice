package multidimensional_arrays;

import java.util.Arrays;

public class StarsDiagonal {

    public String[] showDiagonal(int n) {
        if (n < 0) {
            return new String[]{};
        }

        String[] arr = new String[n + 1];

        for (int i = 0, j = n; (i <= n && j >= 0); i++, j--) {
            String[] line = new String[n + 1];
            Arrays.fill(line, " ");
            line[i] = "*";
            line[j] = "*";
            arr[i] = String.join("", line);
        }

        Arrays.stream(arr)
                .map(s -> s + " ")
                .forEach(System.out::println);
        return arr;
    }
}
