package streamsAPI;

import java.util.Arrays;
import java.util.List;

public class FindNameBeginsWithA {

    public static void main(String[] args) {

        // Array list having names
        List<String> names = Arrays.asList("Divine","Ayush","Deepak","Arun","Priyanka");

        // lambda to stream
        names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //lambda to print list names
        names.forEach(name -> System.out.println(name));

        // OR
        names.forEach(System.out::println);
    }
}
