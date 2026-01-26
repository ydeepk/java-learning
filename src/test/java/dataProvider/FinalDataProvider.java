package dataProvider;


import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/*

The Scenario: You want to run adminLoginTest three times simultaneously
with three different sets of credentials.

The Task:
Update the DataProvider to return 3 rows of data for the adminLoginTest.
In your @Test annotation, add the attribute parallel = true.

Example: @Test(dataProvider = "LoginData", parallel = true)

Question: If you have thread-count="2" in your XML,
but your DataProvider has 10 rows of data and parallel=true, how many browsers will open?

 */
public class FinalDataProvider {

    @DataProvider (parallel = true)
    public Object[][] getUserData(Method m) {

        if(m.getName().equalsIgnoreCase("adminLoginTest")) {
            return new Object[][] {
                    {"adminuser", "adminPassword"},
                    {"adminUser1", "adminPassword"},
                    {"adminUser2", "adminPassword"}
            };
        }

        if(m.getName().equalsIgnoreCase("userLoginTest")) {
            return new Object[][] {{"user", "userPassword"}};
        }

        // default case
        return new Object[][] {{"defaultUser","defaultPassword"}};
    }

}
