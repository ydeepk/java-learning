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

    public static int getPassCount(List<TestResult> results) {
        return countStatus(results,PASS);
    }

    public static int getFailCount(List<TestResult> results) {
        return countStatus(results,FAIL);
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

        int failCount = getFailCount(results);
        int passCount = getPassCount(results);

        statusCount.put(FAIL, failCount);
        statusCount.put(PASS, passCount);

        return statusCount;
    }

    public static Map<String, Integer> getModulePassCount(List<TestResult> results) {

        Map<String, Integer> moduleStatusCount = new HashMap<>();

        for (TestResult result: results) {
            String status = result.getStatus();
            String module = result.getModule();

            if(status == null || module == null) {
                continue;
            }

            status = status.trim();
            module = module.trim();

            if(module.isEmpty() || status.isEmpty()) {
                continue;
            }


            if(status.equalsIgnoreCase(PASS)) {
                int currentCount = moduleStatusCount.getOrDefault(module, 0);
                moduleStatusCount.put(module, currentCount+1);
            }
        }


        return moduleStatusCount;
    }

    /*
    * Your returned list should include only valid rows:
        TC01..TC05
        TC09 (after trim)
        So total count = 6 valid POJO objects
    *
    * */

    public static List<TestResult> toPojoList(List<List<String>> systemInput) {

        List<TestResult> convertedList = new ArrayList<>();

        if(systemInput == null) {
            return convertedList;
        }

        for(List<String> row : systemInput) {



            // if row is null or size less than 3
            if(row == null || row.size()<3) {
                continue;
            }

            String id = row.get(0);
            String status = row.get(1);
            String module = row.get(2);

            // if id is empty or null
            if(id == null || status == null || module == null ) {
                continue;
            }


            id = id.trim();
            status = status.trim();
            module = module.trim();

            // if status is empty or null
            if(id.isEmpty() || status.isEmpty() || module.isEmpty()) {
                continue;
            }

                convertedList.add(new TestResult(id, status, module));

        }

        return convertedList;
    }

}