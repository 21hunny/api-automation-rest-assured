package tests.api.products;

import org.example.model.products.AddProductRequest;
import org.example.model.products.Product;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class AddProductApiTest extends BaseProductsApiTest {

    @Test(description = "POST /products/add adds a new product")
    public void addProduct() {

        AddProductRequest request =
                TestDataManager.readTestDataAsObject(
                        "products/add-product.json",
                        AddProductRequest.class);

        Product product = productApiClient.addProduct(request);

        assertTrue(product.getId() > 0);
        assertEquals(product.getTitle(), request.getTitle());
        assertEquals(product.getCategory(), request.getCategory());
        assertEquals(product.getPrice(), request.getPrice());
    }
}