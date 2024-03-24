package multidimensional_arrays;

import java.util.Arrays;

public class MessageDecrypt {

    public String[] decipherMessage(int[] n) {
        return Arrays.stream(n)
                .mapToObj(j -> String.valueOf(((char) j)))
                .toArray(String[]::new);
    }
}