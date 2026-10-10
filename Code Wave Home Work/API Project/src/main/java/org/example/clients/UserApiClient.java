package org.example.clients;

import org.example.constants.Endpoint;
import org.example.model.users.AddUserRequest;
import org.example.model.users.UpdateUserRequest;
import org.example.model.users.User;
import org.example.model.users.UserList;
import org.example.specifications.users.UserSpecifications;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    // Get all users
    public UserList getAllUsers() {
        return given()
                .spec(UserSpecifications.baseRequestSpec())
                .when()
                .get(Endpoint.USERS)
                .then()
                .spec(UserSpecifications.okResponseSpec())
                .extract()
                .as(UserList.class);
    }

    // Get user by ID
    public User getUserById(int userId) {
        return given()
                .spec(UserSpecifications.baseRequestSpec())
                .pathParam("id", userId)
                .when()
                .get(Endpoint.USER_BY_ID)
                .then()
                .spec(UserSpecifications.okResponseSpec())
                .extract()
                .as(User.class);
    }

    // Add user
    public User addUser(AddUserRequest requestBody) {
        return given()
                .spec(UserSpecifications.baseRequestSpec())
                .body(requestBody)
                .when()
                .post(Endpoint.ADD_USER)
                .then()
                .spec(UserSpecifications.createdResponseSpec())
                .extract()
                .as(User.class);
    }

    // Update user (PUT)
    public User updateUser(int userId, UpdateUserRequest requestBody) {
        return given()
                .spec(UserSpecifications.baseRequestSpec())
                .pathParam("id", userId)
                .body(requestBody)
                .when()
                .put(Endpoint.USER_BY_ID)
                .then()
                .spec(UserSpecifications.okResponseSpec())
                .extract()
                .as(User.class);
    }

    // Delete user
    public User deleteUser(int userId) {
        return given()
                .spec(UserSpecifications.baseRequestSpec())
                .pathParam("id", userId)
                .when()
                .delete(Endpoint.USER_BY_ID)
                .then()
                .spec(UserSpecifications.okResponseSpec())
                .extract()
                .as(User.class);
    }
}