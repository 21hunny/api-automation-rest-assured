package tests.api.cart;

import org.example.clients.CartApiClient;
import org.example.model.carts.AddCartRequest;
import org.example.model.carts.Cart;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class AddCartApiTest extends BaseCartApiTest{

    @Test(description = "POST / carts/add add a new cart")
    public void addCart(){

        AddCartRequest request = TestDataManager.readTestDataAsObject("carts/add-carts.json", AddCartRequest.class);

        Cart cart  = cartApiClient.addCart(request);

        assertTrue(cart.getId() > 0 , "=== Cart Id is not Matched ===");
        assertEquals(cart.getUserId(),request.getUserId());
        assertNotNull(cart.getProducts());
        assertEquals(cart.getProducts().size(), request.getProducts().size(),"=== product size is not matched ===");
        assertTrue(cart.getTotal() > 0);
        assertTrue(cart.getTotalProducts() > 0);
        assertTrue(cart.getTotalQuantity() > 0);
    }

}
