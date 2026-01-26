package streamsAPI;

import java.util.List;
import java.util.stream.Collectors;

public class DataCleaner {

    public static void main(String[] args){
        List<String> names = List.of("john", "ALICE", "john", "bob", "ALICE");
        // Task: 1. Convert all to Uppercase, 2. Get only Unique names, 3. Sort them alphabetically.

        List<String> updatedList = names
                .stream()
                .map(name -> name.toUpperCase())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(updatedList);
    }
}
