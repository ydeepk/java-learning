package strings;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringReverseUsingStreams {

    public static void main(String[] args) {

        String inputStr = "match";

        String reversedStr = Stream.of(inputStr.split(""))
                .reduce("", (s1, s2) -> s2 + s1);

        System.out.println(reversedStr);
    }
}
