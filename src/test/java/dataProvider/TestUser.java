package dataProvider;

import org.testng.annotations.Test;

public class TestUser {

    @Test(dataProvider = "LoginTest", dataProviderClass = SmartDataProvider.class)
    public void adminLoginTest(String user, String password) {
        System.out.print(user+password);
    }

}
