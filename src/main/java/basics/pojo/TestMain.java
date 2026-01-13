package basics.pojo;

import java.util.Arrays;
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
        int passCount = TestAnalyzer.getPassCount(results);
        System.out.println("Exercise 1 - Pass Count: " + passCount);

        // Exercise 2: Get failed test case IDs.
        List<String> failedIds = TestAnalyzer.getFailedIds(results);
        System.out.println("Exercise 2 - Failed IDs: " + failedIds);

        // Exercise 3: Summary counts for pass/fail.
        Map<String, Integer> statusSummary = TestAnalyzer.getStatusCount(results);
        System.out.println("Exercise 3 - Status Summary: " + statusSummary);

        // Exercise 4 — Count Pass by Module (loop + Map)
        Map<String, Integer> countPassByModule = TestAnalyzer.getModulePassCount(results);
        System.out.println("Exercise 4 - Module Pass count: " + countPassByModule);

        // Exercise 5
        List<List<String>> systemInput = List.of(
                Arrays.asList("TC01", "pass", "Login"),
                Arrays.asList("TC02", "fail", "Login"),
                Arrays.asList("TC03", "PASS", "Payments"),
                Arrays.asList("TC04", "Fail", "Payments"),
                Arrays.asList("TC05", "pass", "Search"),

                Arrays.asList("TC06", null, "Search"),
                Arrays.asList("TC07", "pass", null),
                Arrays.asList("TC08"),
                Arrays.asList("TC09", "   pass   ", "  Login ")
        );


        List<TestResult> tpl = TestAnalyzer.toPojoList(systemInput);
        System.out.println("Pojo List size: "+tpl.size());
        System.out.println(tpl);


    }
}