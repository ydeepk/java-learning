package basics.pojo;

import java.util.List;
import java.util.Map;

/**
 * Demo class to run TestAnalyzer exercises.
 * Creates sample test execution results and prints outputs.
 */
public class TestMain {

    public static void main(String[] args) {

        // Sample test execution results.
        List<TestResult> results =
                List.of(
                        new TestResult("TC01", "pass", "Login"),
                        new TestResult("TC02", "fail", "Login"),
                        new TestResult("TC03", "PASS", "Payments"),
                        new TestResult("TC04", "Fail", "Payments"),
                        new TestResult("TC05", "pass", "Search"));

        // Exercise 1: Count passed test cases.
        int passCount = TestAnalyzer.countStatus(results, "pass");
        System.out.println("Exercise 1 - Pass Count: " + passCount);

        // Exercise 2: Get failed test case IDs.
        List<String> failedIds = TestAnalyzer.getFailedIds(results);
        System.out.println("Exercise 2 - Failed IDs: " + failedIds);

        // Exercise 3: Summary counts for pass/fail.
        Map<String, Integer> statusSummary = TestAnalyzer.getStatusCount(results);
        System.out.println("Exercise 3 - Status Summary: " + statusSummary);
    }
}