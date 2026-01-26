package threads;

import dataProvider.FinalDataProvider;
import org.testng.annotations.Test;

/*

The Scenario: You want to run adminLoginTest three times simultaneously
with three different sets of credentials.

The Task:
Update the DataProvider to return 3 rows of data for the adminLoginTest.
In your @Test annotation, add the attribute parallel = true.

Example: @Test(dataProvider = "LoginData", parallel = true)

Question: If you have thread-count="2" in your XML,
but your DataProvider has 10 rows of data and parallel=true, how many browsers will open?


Solution:

First, how many browser it will open ? answer is two, as thread is limited to 2 counts in my XML file.

secondly, now moving to the main exercise above.



* */
public class FinalTestNgTest {


    @Test(dataProvider = "getUserData" , dataProviderClass = FinalDataProvider.class)
    public void adminLoginTest(String user, String password) {
        System.out.println("Print out -> "+user +" "+password);
    }

}
