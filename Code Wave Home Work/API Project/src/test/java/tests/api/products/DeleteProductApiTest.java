package tests.api.products;

import org.example.model.products.GetProductEndpointData;
import org.example.model.products.Product;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class DeleteProductApiTest extends BaseProductsApiTest {

    @Test(description = "DELETE /products/{id} deletes a product")
    public void deleteProduct() {

        GetProductEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "products/get-product.json",
                        GetProductEndpointData.class);

        Product product =
                productApiClient.deleteProduct(endpointData.getId());

        assertEquals(product.getId(), endpointData.getId());
    }
}