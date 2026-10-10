package tests.api.users;

import org.example.clients.UserApiClient;
import org.testng.annotations.*;

public class BaseUserApiTest {

    protected UserApiClient userApiClient;

    @BeforeClass
    public void setUp() {
        userApiClient = new UserApiClient();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("===== Before Method =====");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("===== After Method =====");
    }

    @AfterTest
    public void cleanUp() {
        System.out.println("===== Clean Up =====");
    }
}