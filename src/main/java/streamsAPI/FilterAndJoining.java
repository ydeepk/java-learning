package streamsAPI;

import java.util.List;
import java.util.stream.Collectors;

public class FilterAndJoining {

    public static void main(String[] args) {

        /*
        * Filtering and Joining

The Scenario: You have a list of names.
* You need to filter out names that start with "A", convert them to Uppercase,
* and join them into a single String separated by a comma.*/

        List<String> fruits = List.of("Apple", "Banana", "Apricot", "Cherry", "Avocado");

        String filteredFruits = fruits
                .stream()
                .filter(fruit -> fruit.startsWith("A"))
                .map(fruit -> fruit.toUpperCase())
                .collect(Collectors.joining(" , "));

        System.out.println(filteredFruits);
    }
}
