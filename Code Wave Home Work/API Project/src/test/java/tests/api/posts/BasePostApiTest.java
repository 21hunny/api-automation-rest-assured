package tests.api.posts;

import org.example.clients.PostApiClient;
import org.testng.annotations.*;

public class BasePostApiTest {

    protected PostApiClient postApiClient;

    @BeforeClass
    public void setUp() {
        postApiClient = new PostApiClient();
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