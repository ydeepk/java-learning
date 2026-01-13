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
 * - Count passed tests per module
 * - Convert raw nested list input to POJO list
 */
public class TestAnalyzer {

    private static final String PASS = "pass";
    private static final String FAIL = "fail";

    // Raw input indexes for List<List<String>> conversion.
    private static final int INDEX_ID = 0;
    private static final int INDEX_STATUS = 1;
    private static final int INDEX_MODULE = 2;

    /**
     * Counts the number of test results that match the expected status.
     */
    public static int countStatus(List<TestResult> results, String expectedStatus) {
        if (results == null || expectedStatus == null) {
            return 0;
        }

        int matchCount = 0;

        for (TestResult result : results) {
            if (result == null) {
                continue;
            }

            String status = result.getStatus();

            // Null safe and whitespace safe comparison.
            if (status != null && status.trim().equalsIgnoreCase(expectedStatus)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    /** Returns total PASS count. */
    public static int getPassCount(List<TestResult> results) {
        return countStatus(results, PASS);
    }

    /** Returns total FAIL count. */
    public static int getFailCount(List<TestResult> results) {
        return countStatus(results, FAIL);
    }

    /**
     * Returns a list of test case IDs where status is FAIL.
     */
    public static List<String> getFailedIds(List<TestResult> results) {
        List<String> failedIds = new ArrayList<>();

        if (results == null) {
            return failedIds;
        }

        for (TestResult result : results) {
            if (result == null) {
                continue;
            }

            String status = result.getStatus();

            if (status != null && status.trim().equalsIgnoreCase(FAIL)) {
                failedIds.add(result.getId());
            }
        }

        return failedIds;
    }

    /**
     * Returns summary of pass/fail counts.
     * Example output: {fail=2, pass=3}
     */
    public static Map<String, Integer> getStatusCount(List<TestResult> results) {
        Map<String, Integer> statusCount = new HashMap<>();

        statusCount.put(FAIL, getFailCount(results));
        statusCount.put(PASS, getPassCount(results));

        return statusCount;
    }

    /**
     * Returns module-wise PASS count.
     * Example output: {Login=1, Payments=1, Search=1}
     */
    public static Map<String, Integer> getModulePassCount(List<TestResult> results) {
        Map<String, Integer> modulePassCount = new HashMap<>();

        if (results == null) {
            return modulePassCount;
        }

        for (TestResult result : results) {
            if (result == null) {
                continue;
            }

            String status = result.getStatus();
            String module = result.getModule();

            if (status == null || module == null) {
                continue;
            }

            status = status.trim();
            module = module.trim();

            if (status.isEmpty() || module.isEmpty()) {
                continue;
            }

            // Increase module count only for PASS.
            if (status.equalsIgnoreCase(PASS)) {
                int currentCount = modulePassCount.getOrDefault(module, 0);
                modulePassCount.put(module, currentCount + 1);
            }
        }

        return modulePassCount;
    }

    /**
     * Converts raw system input to POJO list.
     * Only valid rows are converted.
     */
    public static List<TestResult> toPojoList(List<List<String>> systemInput) {
        List<TestResult> convertedList = new ArrayList<>();

        if (systemInput == null) {
            return convertedList;
        }

        for (List<String> row : systemInput) {

            // Skip invalid rows.
            if (row == null || row.size() < 3) {
                continue;
            }

            String id = row.get(INDEX_ID);
            String status = row.get(INDEX_STATUS);
            String module = row.get(INDEX_MODULE);

            // Skip rows with missing values.
            if (id == null || status == null || module == null) {
                continue;
            }

            id = id.trim();
            status = status.trim();
            module = module.trim();

            // Skip rows with blank values.
            if (id.isEmpty() || status.isEmpty() || module.isEmpty()) {
                continue;
            }

            convertedList.add(new TestResult(id, status, module));
        }

        return convertedList;
    }
}