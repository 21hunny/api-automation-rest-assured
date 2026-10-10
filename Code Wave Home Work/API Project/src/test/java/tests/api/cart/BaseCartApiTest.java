package tests.api.cart;

import org.example.clients.CartApiClient;
import org.example.utils.ConfigManager;
import org.testng.annotations.*;

public class BaseCartApiTest {
    protected int cartId;
    protected int userId;
    protected CartApiClient cartApiClient;

    @BeforeClass
    public void setUp() {
          cartId = Integer.parseInt(ConfigManager.get("carts.cartId"));
          userId = Integer.parseInt(ConfigManager.get("carts.userId"));
          cartApiClient = new CartApiClient();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.printf("=====beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.printf("=====after ,et up");
    }

    @AfterTest
    public void cleanUp() {
        System.out.printf("=====Clean up");
    }
}
