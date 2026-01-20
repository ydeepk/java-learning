package streamsAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixLambdaIssueExercise {

        public static void main(String[] args) {
            List<String> browsers = Arrays.asList("Chrome", "Firefox", "Edge", "Safari", "Opera");

            // TASK 1: Print all browsers that start with "C"
            System.out.println("Browsers starting with C:");
            browsers.stream()
                    .filter(b -> b.startsWith("C"))
                    .forEach(System.out::println);

            // TASK 2: Create a new list where all browser names are UPPERCASE
            List<String> upperBrowsers = browsers.stream()
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

            System.out.println(upperBrowsers);
        }


}
