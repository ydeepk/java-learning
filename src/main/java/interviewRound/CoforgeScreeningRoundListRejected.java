package interviewRound;

import java.util.List;
import java.util.Map;

public class CoforgeScreeningRoundListRejected {

    // Test scenario, need to count number of pass test cases for the executed test cases stored in list as Id and status pass/fail.
    //Note: if not aware of streams, then feel free to use the Loops.

   public static void main(String[] args) {

       // X incorrect List.of declarations
      // List<List<String>> testResults = List.of({"1","pass"},{"2","pass"},{"3","fail"});
       int counterPass = 0;

       /* X incorrect data type used, List is declared above and now Map is used
       for(Map<String, String> result : testResults.entrySet()) {

           String testStatus = result.get(1);

           if(testStatus.trim().equals("pass")) {
               counterPass++;
           }
       }
*/
       System.out.println(counterPass);
   }
}
