package tests.api.comments;

import org.example.clients.CommentApiClient;
import org.testng.annotations.*;

public class BaseCommentApiTest {

    protected CommentApiClient commentApiClient;

    @BeforeClass
    public void setUp() {
        commentApiClient = new CommentApiClient();
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