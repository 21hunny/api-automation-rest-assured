package tests.api.quotes;

import org.example.clients.QuoteApiClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseQuoteApiTest {

    protected QuoteApiClient quoteApiClient;

    @BeforeClass
    public void setUp() {
        quoteApiClient = new QuoteApiClient();
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