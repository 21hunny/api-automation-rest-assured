package org.example.clients;

import org.example.constants.Endpoint;
import org.example.model.products.*;
import org.example.specifications.products.ProductSpecifications;

import static io.restassured.RestAssured.given;

public class ProductApiClient {

    public ProductList getAllProducts() {

        return given()
                .spec(ProductSpecifications.baseRequestSpec())
                .when()
                .get(Endpoint.PRODUCTS)
                .then()
                .spec(ProductSpecifications.okResponseSpec())
                .extract()
                .as(ProductList.class);
    }

    public Product getProductById(int id) {

        return given()
                .spec(ProductSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoint.PRODUCT_BY_ID)
                .then()
                .spec(ProductSpecifications.okResponseSpec())
                .extract()
                .as(Product.class);
    }

    public Product addProduct(AddProductRequest request) {

        return given()
                .spec(ProductSpecifications.baseRequestSpec())
                .body(request)
                .when()
                .post(Endpoint.ADD_PRODUCT)
                .then()
                .spec(ProductSpecifications.createdResponseSpec())
                .extract()
                .as(Product.class);
    }

    public Product updateProduct(int id, UpdateProductRequest request) {

        return given()
                .spec(ProductSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .body(request)
                .when()
                .put(Endpoint.PRODUCT_BY_ID)
                .then()
                .spec(ProductSpecifications.okResponseSpec())
                .extract()
                .as(Product.class);
    }

    public Product deleteProduct(int id) {

        return given()
                .spec(ProductSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .when()
                .delete(Endpoint.PRODUCT_BY_ID)
                .then()
                .spec(ProductSpecifications.okResponseSpec())
                .extract()
                .as(Product.class);
    }
}