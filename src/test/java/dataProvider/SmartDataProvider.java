package dataProvider;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Exercise 2: The "Smart" DataProvider (Real World)
 * The Scenario: You need to test a Login page with 3 sets of data:
 * Valid User, Invalid Password, and Locked User.
 *
 * Task:
 * Create a @DataProvider method that returns a Object[][].
 * Write a @Test method that uses this DataProvider.
 * The Twist: Use the Method object as a parameter in your DataProvider
 * so it only returns "Admin" data if the calling test name is adminTest.
 * (This is how seniors manage large data sets!).
 * */
public class SmartDataProvider {

@DataProvider(name = "LoginTest")
public static Object[][] userLoginData(Method m) {

    switch (m.getName()) {
        case "adminLoginTest":
            return new Object[][] {{
                        "guestAdmin",
                            "Admin123"
                    }};
        case "userLoginTest":
            return new Object[][] {{
                    "guestuser",
                    "user123"
            }};
        default:
            throw new RuntimeException("invalid method provided");
    }

}

}