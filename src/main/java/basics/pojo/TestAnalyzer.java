package basics.pojo;

import java.util.ArrayList;
import java.util.List;

public class TestAnalyzer {

    private static final String PASS = "pass";
    private static final String FAIL = "fail";

    public static int countPass(List<TestResult> results)
    {

        int counter=0;

        for(TestResult result: results) {
            String actualResult = result.getStatus().trim();
            if(actualResult != null & actualResult.equalsIgnoreCase(PASS)) {
                counter++;
            }
        }

        return counter;
    }

    public static List<String> getFailedIds(List<TestResult> results) {

        List<String> failedIds = new ArrayList<>();

        for(TestResult result:results) {

            String actualResult = result.getStatus();
            if(actualResult != null && actualResult.trim().equalsIgnoreCase(FAIL)) {
                failedIds.add(result.getId());
            }

        }

        return failedIds;
    }

}
