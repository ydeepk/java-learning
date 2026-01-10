package interviewRound;

import java.util.List;

/**
 * Demonstrates counting how many executed test cases have status "pass".
 *
 * Input format:
 * Each element in the outer list represents one test result:
 *   [testCaseId, status]
 *
 * Example:
 *   ["1", "pass"]
 *   ["2", "fail"]
 */
public class CoforgeScreeningRoundExpectedCode {

    // Index constants improve readability and avoid "magic numbers" in code.
    private static final int INDEX_STATUS = 1;

    public static void main(String[] args) {

        // Test execution results stored as [id, status].
        // In real projects, prefer using a POJO/class instead of List<List<String>>.
        List<List<String>> testExecutionResults =
                List.of(
                        List.of("1", "pass"),
                        List.of("2", "PAss"),
                        List.of("3", "fail"),
                        List.of("4", "Pass")
                );

        // Count the number of rows where:
        // - status exists (not null)
        // - status equals "pass" (case-insensitive)
        long passCount =
                testExecutionResults.stream()
                        // Defensive check: ensure the row has at least 2 values: [id, status].
                        .filter(row -> row.size() > INDEX_STATUS)
                        // Extract the status from each row.
                        .map(row -> row.get(INDEX_STATUS))
                        // Filter null statuses (avoid NullPointerException in trim/equalsIgnoreCase).
                        .filter(status -> status != null)
                        // Normalize by trimming whitespace and compare ignoring case.
                        .filter(status -> status.trim().equalsIgnoreCase("pass"))
                        .count();

        System.out.println(passCount);
    }
}