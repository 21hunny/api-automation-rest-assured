package tests.api.cart;

import org.example.clients.CartApiClient;
import org.example.model.carts.Cart;
import org.example.model.carts.CartList;
import org.example.model.carts.GetEndpointData;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class GetCartTest extends BaseCartApiTest {

    @Test(description = "GET /carts returns cart list")
    public void getAllCarts() {
        CartList response = cartApiClient.getAllCarts();

        assertNotNull(response.getCarts());
        assertFalse(response.getCarts().isEmpty());
        assertTrue(response.getTotal() > 0);
        assertTrue(response.getLimit() > 0);
        assertTrue(response.getSkip() >= 0);
    }

    @Test(description = "GET /carts/{id} returns specific cart")
    public void getCartById() {
        GetEndpointData getEndpointData = TestDataManager.readTestDataAsObject("carts/get-carts.json",GetEndpointData.class);
        Cart cart = cartApiClient.getCartById(getEndpointData.getId());

        assertEquals(cart.getId(), getEndpointData.getId());
        assertNotNull(cart.getProducts());
        assertFalse(cart.getProducts().isEmpty());
        assertTrue(cart.getTotal() > 0);
        assertTrue(cart.getUserId() > 0);
        assertTrue(cart.getTotalProducts() > 0);
        assertTrue(cart.getTotalQuantity() > 0);


    }
}
