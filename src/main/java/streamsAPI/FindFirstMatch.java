package streamsAPI;

import java.util.List;

public class FindFirstMatch {

    public static void main(String[] args) {

        List<String> logs = List.of("Info: Start", "Error: Timeout", "Info: Loading", "Error: Crash");

        String firstError = logs.stream()
                .filter(s -> s.startsWith("Error"))
                // YOUR CODE HERE: Get just the first match
                .findFirst()
                .orElse("No Error Found");

        System.out.println(firstError);
    }
}
