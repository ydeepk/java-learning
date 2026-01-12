package basics.pojo;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        List<TestResult> results = List.of(
                new TestResult("TC01", "pass", "Login"),
                new TestResult("TC02", "fail", "Login"),
                new TestResult("TC03", "PASS", "Payments"),
                new TestResult("TC04", "Fail", "Payments"),
                new TestResult("TC05", "pass", "Search")
        );

        // exercise 1 implement countPass()
        int passCount = TestAnalyzer.countPass(results);

        System.out.println(passCount);

        // exercise 2 implement getFailedTest Ids

        List<String> failedIds = TestAnalyzer.getFailedIds(results);

        System.out.println(failedIds);

    }
}
