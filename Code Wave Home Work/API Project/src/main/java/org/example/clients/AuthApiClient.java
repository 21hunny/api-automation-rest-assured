package org.example.clients;

import org.example.constants.Endpoint;
import org.example.model.auth.CurrentUser;
import org.example.model.auth.LoginRequest;
import org.example.model.auth.LoginResponse;
import org.example.model.auth.RefreshTokenRequest;
import org.example.model.auth.RefreshTokenResponse;
import org.example.specifications.auth.AuthSpecifications;

import static io.restassured.RestAssured.given;

public class AuthApiClient {

    public LoginResponse login(LoginRequest request) {

        return given()
                .spec(AuthSpecifications.baseRequestSpec())
                .body(request)
                .when()
                .post(Endpoint.LOGIN)
                .then()
                .spec(AuthSpecifications.okResponseSpec())
                .extract()
                .as(LoginResponse.class);
    }

    public CurrentUser getCurrentUser(String accessToken) {

        return given()
                .spec(AuthSpecifications.baseRequestSpec())
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(Endpoint.CURRENT_USER)
                .then()
                .spec(AuthSpecifications.okResponseSpec())
                .extract()
                .as(CurrentUser.class);
    }

    public RefreshTokenResponse refreshToken(RefreshTokenRequest request) {

        return given()
                .spec(AuthSpecifications.baseRequestSpec())
                .body(request)
                .when()
                .post(Endpoint.REFRESH_TOKEN)
                .then()
                .spec(AuthSpecifications.okResponseSpec())
                .extract()
                .as(RefreshTokenResponse.class);
    }
}