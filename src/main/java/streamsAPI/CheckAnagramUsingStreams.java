package streamsAPI;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckAnagramUsingStreams {

    public static void main(String[] args) {

        String input1 = "listen";
        String input2 = "silent";

        checkAnagram(input1, input2);
    }

    private static boolean checkAnagram(String input1, String input2) {
        var map1 = input1.
                chars().
                boxed().collect(
                        Collectors.groupingBy(
                                c -> c,
                                Collectors.counting()
                        ));

        var map2 = input2
                .chars()
                .boxed().collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));

        return map1.equals(map2);
    }
}
