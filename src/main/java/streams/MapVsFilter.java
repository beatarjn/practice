package streams;

import java.util.ArrayList;
import java.util.List;

public class MapVsFilter {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        List<Integer> listStream = list.stream()
                .map(i -> {
                    System.out.println("map " + i);
                    return Integer.parseInt(i);
                })
                .filter(integer -> {
                    System.out.println("filter " + integer);
                    return integer > 4;
                })
                .toList();


        System.out.println(listStream);

        System.out.println("===========");

        List<Integer> listS1 = list.stream()
                .filter(integer -> {
                    System.out.println("filter " + integer);
                    return Integer.parseInt(integer) > 4;
                })
                .map(i -> {
                    System.out.println("map " + i);
                    return Integer.parseInt(i);
                })
                .toList();

        System.out.println(listS1);
    }

}