package streamsAPI;

import java.util.List;

public class TestScores {

    public static void main(String[] args) {

        /*
        * Scenario: You have a list of test scores.
        * Find the average of all scores that are passing (greater than or equal to 60).
        * */

        List<Integer> scores = List.of(45, 88, 72, 50, 95, 30);

        double averageScore = scores
                .stream()
                .filter(score -> score >= 60)
                .mapToInt(s ->  s)
                .average()
                .orElse(0.0);

        System.out.println(averageScore);
    }
}
