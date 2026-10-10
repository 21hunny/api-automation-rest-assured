package tests.api.products;

import org.example.model.products.GetProductEndpointData;
import org.example.model.products.Product;
import org.example.model.products.UpdateProductRequest;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class UpdateProductApiTest extends BaseProductsApiTest {

    @Test(description = "PUT /products/{id} updates a product")
    public void updateProduct() {

        UpdateProductRequest request =
                TestDataManager.readTestDataAsObject(
                        "products/update-product.json",
                        UpdateProductRequest.class);

        GetProductEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "products/get-product.json",
                        GetProductEndpointData.class);

        Product product =
                productApiClient.updateProduct(
                        endpointData.getId(),
                        request);

        assertEquals(product.getId(), endpointData.getId());
        assertEquals(product.getTitle(), request.getTitle());
        assertEquals(product.getCategory(), request.getCategory());
    }
}