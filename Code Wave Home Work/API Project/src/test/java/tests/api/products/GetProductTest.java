package tests.api.products;

import org.example.model.products.GetProductEndpointData;
import org.example.model.products.Product;
import org.example.model.products.ProductList;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class GetProductTest extends BaseProductsApiTest {

    @Test(description = "GET /products returns product list")
    public void getAllProducts() {

        ProductList response = productApiClient.getAllProducts();

        assertNotNull(response.getProducts());
        assertFalse(response.getProducts().isEmpty());
        assertTrue(response.getTotal() > 0);
        assertTrue(response.getLimit() > 0);
        assertTrue(response.getSkip() >= 0);
    }

    @Test(description = "GET /products/{id} returns specific product")
    public void getProductById() {

        GetProductEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "products/get-product.json",
                        GetProductEndpointData.class);

        Product product =
                productApiClient.getProductById(endpointData.getId());

        assertEquals(product.getId(), endpointData.getId());
        assertNotNull(product.getTitle());
        assertNotNull(product.getCategory());
        assertTrue(product.getPrice() > 0);
    }
}