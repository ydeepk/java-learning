package streamsAPI;

import java.util.List;

public class IfAnyContainsWordPro {

    public static void main(String[] args) {

        List<String> results = List.of("iPhone 15", "iPhone 15 Pro", "iPhone 15 Pro Max");
// Task: Write a stream that returns a boolean if any result contains "Pro"

        boolean containsPro = results.stream()
                .anyMatch(word -> word.contains("Pro"));
    }
}
