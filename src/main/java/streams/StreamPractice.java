package streams;

import org.apache.commons.text.RandomStringGenerator;

import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {

    private static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("====2====");
        printNumberOfDigitsDivisibleBy6();

        System.out.println("====3====");
        printFirstNumberDivisibleBy37();

        System.out.println("====4====");
        sumAllDigits();

        System.out.println("====5====");
        checkIfAllDigitsInTheRange();

        System.out.println("====6====");
        numberOfUniqueDigits();

        System.out.println("====7====");
        printUniqueDigits();

        System.out.println("====8====");
        removeDigitsDivisibleBy3AndPrintList();

        System.out.println("====9====");
        printDigitsFromIndex15To30();

        System.out.println("====10====");
        convertDigitsToString();

        System.out.println("====11====");
        sortList();

        System.out.println("====12====");
        printLargestValueFromTheList();

        System.out.println("====13====");
        printSmallestValueFromTheList();

        System.out.println("====14====");
        convertListToSet();

        System.out.println("====15====");
        printDigitsConvertedToRandomWords();

        System.out.println("====16====");
        getWordsContainingVowels();

        System.out.println("====17====");
        createWordOutOfAllWordsInAList();
    }

    // 1. create list of ints of size 100 with random values between 0-100 (using IntStream)
    public static void createRandomNumbersList() {
        IntStream stream = IntStream
                .generate(() -> random.nextInt())
                .limit(100);

        IntStream ints = random.ints(100, 0, 100);
    }

    // 2. Write to the console how many divisible numbers there are for 6
    public static void printNumberOfDigitsDivisibleBy6() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("Number of digits divisible by 6: " + stream.filter(i -> i % 6 == 0).count());
    }

    // 3. Check if there is at least one element among them divisible by 37 and if so, print the first one.
    public static void printFirstNumberDivisibleBy37() {
        IntStream stream = random.ints(100, 0, 100);

        OptionalInt first = stream
                .filter(i -> i % 37 == 0)
                .findFirst();

        if (first.isPresent()) {
            System.out.println("First digit divisible by 37: " + first.getAsInt());
        }
    }

    // 4. Add up all the elements and write the result to console.
    public static void sumAllDigits() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("Sum of all digits: " + stream.sum());
    }

    // 5. Check whether all elements are definitely greater than or equal to 0 and simultaneously less than or equal to 100..
    public static void checkIfAllDigitsInTheRange() {
        IntStream stream = random.ints(100, 0, 100);

        long count = stream
                .filter(i -> i > 100 || i < 0)
                .count();

        System.out.println(count == 0 ? "All digits in range." : "Not all digit are in range.");
    }

    // 6. Print to the console how many unique numbers there are (without repetitions).
    public static void numberOfUniqueDigits() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("Number of unique digits: " + stream.distinct().count());
    }

    // 7. Print only unique numbers to the console (without repetitions).
    public static void printUniqueDigits() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("Unique digits: ");
        List<Integer> list = stream
                .distinct()
                .boxed()
                .toList();

        print(list);
    }

    // 8. Remove items from the list that are divisible by 3 and write a new list to the console.
    public static void removeDigitsDivisibleBy3AndPrintList() {
        IntStream stream = random.ints(100, 0, 100);

        List<Integer> list = stream
                .filter(i -> i % 3 != 0)
                .boxed()
                .toList();

        System.out.println("List without numbers divisible by 3: ");
        print(list);
    }

    // 9. List the elements with indexes from 15 inclusive to 30 inclusive.
    public static void printDigitsFromIndex15To30() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("Digits from index 15 to 30: ");
        List<Integer> list = stream
                .skip(15)
                .limit(16)
                .boxed()
                .toList();

        print(list);
    }

    // 10. Convert ints to their value in String (e.g.: 10 -> “10”) and write the new list to the console.
    public static void convertDigitsToString() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("Digits to String: ");
        List<String> list = stream
                .mapToObj(Integer::toString)
                .toList();

        printList(list);
    }

    // 11. Sort the list and write to the console.
    public static void sortList() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("Sorted list: ");

        List<Integer> list = stream
                .sorted()
                .boxed()
                .toList();
        print(list);
    }

    // 12. Print the largest value from the list.
    public static void printLargestValueFromTheList() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("The largest value from the list: " + stream.max().getAsInt());
    }

    // 13. Print the smallest value from the list.
    public static void printSmallestValueFromTheList() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("The smallest value from the list: " + stream.min().getAsInt());
    }

    // 14. Convert the list to a set and print.
    public static void convertListToSet() {
        IntStream stream = random.ints(100, 0, 100);

        System.out.println("List to set: ");
        Set<Integer> set = stream
                .boxed()
                .collect(Collectors.toSet());

        set.stream()
                .map(i -> i + " ")
                .forEach(System.out::print);
        System.out.println();
    }

    // 15. Replace each item from the list with a word with the same number of letters in it as the value of the
    // number from the list. Let the word consist of random letters. Use only lowercase letters, no Polish characters.

    public static void printDigitsConvertedToRandomWords() {
        System.out.println("Randomly generated words: ");
        printList(convertDigitToRandomWord());
    }

    private static List<String> convertDigitToRandomWord() {
        IntStream stream = random.ints(100, 0, 100);

        List<Integer> numbers = stream
                .boxed().toList();

        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();

        return numbers.stream()
                .map(integer -> generator.generate(integer))
                .toList();
    }

    // 16. Then leave only those words that contain some vowel.
    public static void getWordsContainingVowels() {
        List<String> words = convertDigitToRandomWord();

        String vowels = ".*[aeiou].*";

        System.out.println("Words with vowels: ");
        List<String> list = words.stream()
                .filter(w -> w.matches(vowels))
                .toList();

        printList(list);
    }

    //17. Output one String to the console, which will consist of all words in the stream, separated by a space and sorted.

    public static void createWordOutOfAllWordsInAList() {
        List<String> words = convertDigitToRandomWord();
        System.out.println("All words from the list: ");
        printList(words);

        String joined = words.stream()
                .sorted()
                .collect(Collectors.joining(" "));

        System.out.println("One word from all elements: ");
        System.out.println(joined);
    }

    private static void print(List<Integer> list) {
        list.stream()
                .map(i -> i + " ")
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printList(List<String> list) {
        list.stream()
                .map(i -> i + " ")
                .forEach(System.out::print);
        System.out.println();
    }

}