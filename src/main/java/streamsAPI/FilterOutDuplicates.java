package streamsAPI;

import java.util.List;
import java.util.stream.Collectors;

public class FilterOutDuplicates {

    public static void main(String[] args) {

        List<String> rawData = List.of("Laptop", "Phone", "Laptop", "Tablet", "Phone");

        List<String> uniqueData = rawData.stream()
                .distinct() // Filter out duplicates
                .collect(Collectors.toList());

        System.out.println(uniqueData);
    }
}
