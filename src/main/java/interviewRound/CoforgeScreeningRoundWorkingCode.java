package interviewRound;

import java.util.List;

public class CoforgeScreeningRoundWorkingCode {


    // Test scenario, need to count number of pass test cases for the executed test cases stored in list as Id and status pass/fail.
    //Note: if not aware of streams, then feel free to use the Loops.

    public static void main(String[] args) {

        // List containing test execution result.
        List<List<String>> testResults = List.of(
                List.of("1","pass"),
                List.of("2", "fail"),
                List.of("3", "pass")
        );

        int passCounter = 0; // initialise counter
        String matchCase = "pass"; // initialised match case for comparison

        for(List<String> result: testResults) {

            String resultValue = result.get(1).toLowerCase().trim();

            if(resultValue.equalsIgnoreCase(matchCase)) {
                passCounter++;
            }

        }

        System.out.println("Test cases passed: "+ passCounter);
    }
}
