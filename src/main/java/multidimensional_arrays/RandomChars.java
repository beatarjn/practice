package multidimensional_arrays;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomChars {

    public static void main(String[] args) {
        System.out.println(generate());
    }

    public static String generate() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*()_+-=[]|,./?><";
        return RandomStringUtils.random(10, characters);
    }
}