package tests.api.products;

import org.example.clients.ProductApiClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseProductsApiTest {

    protected ProductApiClient productApiClient;

    @BeforeClass
    public void setUp() {

        productApiClient = new ProductApiClient();
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