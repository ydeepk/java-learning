package streamsAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FrequencyMap {

    public static void main(String[] args) {

        List<String> fruits = List.of("apple","mango","apple","mango","strawberry");

        Map<String, Long> frequencyCount = fruits.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));

        System.out.println(frequencyCount);
    }
}
