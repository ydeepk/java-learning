package streamsAPI;

import java.util.Arrays;
import java.util.List;

public class CountUniqueWordsFromSentence {

    public static void main(String[] args) {

        String inputString = "Java is java and not a sentence not";

        long countUniqueWords = Arrays
        .stream(inputString.split("\\s+"))
                .map(word -> word.toLowerCase())
                .distinct()
                .count();

        System.out.println(countUniqueWords);
    }
}
