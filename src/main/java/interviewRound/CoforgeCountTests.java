package interviewRound;

import java.util.List;

public class CoforgeCountTests {

    /**
     * Demonstrates counting how many executed test cases have status "pass" using POJO class.
     *
     * Input format:
     * Each element in the outer list represents one test result:
     *   [testCaseId, status]
     *
     * Example:
     *   ["1", "pass"]
     *   ["2", "fail"]
     */


    public static void main(String[] args) {

        List<CoforgeTestExecution> testResult = List.of(
                new CoforgeTestExecution("1","pass"),
                new CoforgeTestExecution("3","PAss"),
                new CoforgeTestExecution("2","pass"),
                new CoforgeTestExecution("4","Fail")
        );

        long count = testResult
                .stream()
                .map(CoforgeTestExecution::getStatus)
                .filter(status -> status != null)
                .filter(status -> status.trim().equalsIgnoreCase("pass"))
                .count();

        System.out.println(count);

    }
}
