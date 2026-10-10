package org.example.clients;

import io.restassured.http.ContentType;
import org.example.constants.Endpoint;
import org.example.model.carts.AddCartRequest;
import org.example.model.carts.Cart;
import org.example.model.carts.CartList;
import org.example.model.carts.UpdateCartRequest;
import org.example.specifications.carts.CartSpecifications;

import static io.restassured.RestAssured.given;

public class CartApiClient {

    //GetAllCarts
    public CartList getAllCarts(){
        return given()
                .spec(CartSpecifications.baseRequestSpec())
                .when()
                .get(Endpoint.CART)
                .then()
                .spec(CartSpecifications.okResponseSpec())
                .extract()
                .as(CartList.class);
    }


    //GetCartByID

    public Cart getCartById(int cartId) {
        return given()
                .spec(CartSpecifications.baseRequestSpec())
                .pathParam("id", cartId)
                .when()
                .get(Endpoint.CART_BY_ID)
                .then()
                .spec(CartSpecifications.okResponseSpec())
                .extract()
                .as(Cart.class);
    }

    //getting carts by user

    //Adding a new cart
    public Cart addCart(AddCartRequest requestBody){
        return given()
                .spec(CartSpecifications.baseRequestSpec())
                .body(requestBody)
                .when()
                .post(Endpoint.ADD_CART)
                .then()
                .spec(CartSpecifications.createdResponseSpec())
                .extract()
                .as(Cart.class);
    }

    //Updating a cart - put\
    public Cart updateCart(int cartId, UpdateCartRequest request) {
        return given()
                .spec(CartSpecifications.baseRequestSpec())
                .pathParam("id", cartId)
                .body(request)
                .when()
                .put(Endpoint.CART_BY_ID)
                .then()
                .spec(CartSpecifications.okResponseSpec())
                .extract()
                .as(Cart.class);
    }


    //Updating a cart - patch
    //delete


}
