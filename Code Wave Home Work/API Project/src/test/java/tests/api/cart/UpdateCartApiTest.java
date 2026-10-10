package tests.api.cart;

import org.example.clients.CartApiClient;
import org.example.model.carts.*;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class UpdateCartApiTest extends BaseCartApiTest {

    @Test(description = "PUT /carts/{id} updates a cart (simulated)")
    public void updateCartWithPut() {

        UpdateCartRequest request = TestDataManager.readTestDataAsObject("carts/update-cart.json", UpdateCartRequest.class);
        GetEndpointData getEndpointData = TestDataManager.readTestDataAsObject("carts/get-carts.json",GetEndpointData.class);

        Cart cart = cartApiClient.updateCart(getEndpointData.getId(), request);

        assertEquals(cart.getId(), getEndpointData.getId());
        assertNotNull(cart.getProducts());
        assertTrue(cart.getTotal() > 0);
        assertTrue(cart.getTotalProducts() > 0);
        assertTrue(cart.getTotalQuantity() > 0);
        int index = 0;
        for (CartProduct cartProduct :  cart.getProducts()){



        }

    }

}
