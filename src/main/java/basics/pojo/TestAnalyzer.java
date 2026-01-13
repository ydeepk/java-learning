package basics.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for analyzing executed test results.
 * Provides helper methods to:
 * - Count test results by status (pass/fail)
 * - Get failed test case IDs
 * - Generate summary counts for pass/fail
 */
public class TestAnalyzer {

    private static final String PASS = "pass";
    private static final String FAIL = "fail";

    /**
     * Counts the number of test results that match the expected status.
     *
     * @param results List of executed test results
     * @param expectedStatus Status to match (example: "pass", "fail")
     * @return Count of test results matching the expected status
     */
    public static int countStatus(List<TestResult> results, String expectedStatus) {
        int matchCount = 0;

        for (TestResult result : results) {
            String status = result.getStatus();

            // Null safe and whitespace safe comparison.
            if (status != null && status.trim().equalsIgnoreCase(expectedStatus)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    /**
     * Returns a list of test case IDs where status is "fail".
     *
     * @param results List of executed test results
     * @return List of failed test case IDs
     */
    public static List<String> getFailedIds(List<TestResult> results) {
        List<String> failedIds = new ArrayList<>();

        for (TestResult result : results) {
            String status = result.getStatus();

            if (status != null && status.trim().equalsIgnoreCase(FAIL)) {
                failedIds.add(result.getId());
            }
        }

        return failedIds;
    }

    /**
     * Returns summary of pass/fail counts.
     *
     * @param results List of executed test results
     * @return Map containing status as key and count as value
     */
    public static Map<String, Integer> getStatusCount(List<TestResult> results) {
        Map<String, Integer> statusCount = new HashMap<>();

        int failCount = countStatus(results, FAIL);
        int passCount = countStatus(results, PASS);

        statusCount.put(FAIL, failCount);
        statusCount.put(PASS, passCount);

        return statusCount;
    }
}