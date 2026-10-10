package tests.api.auth;

import org.example.model.auth.LoginRequest;
import org.example.model.auth.LoginResponse;
import org.example.model.auth.RefreshTokenRequest;
import org.example.model.auth.RefreshTokenResponse;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class RefreshTokenApiTest extends BaseAuthApiTest {

    @Test(description = "POST /auth/refresh")
    public void refreshToken() {

        LoginRequest loginRequest =
                TestDataManager.readTestDataAsObject(
                        "auth/login.json",
                        LoginRequest.class);

        LoginResponse login =
                authApiClient.login(loginRequest);

        RefreshTokenRequest request = new RefreshTokenRequest();
        request.setRefreshToken(login.getRefreshToken());

        RefreshTokenResponse response =
                authApiClient.refreshToken(request);

        assertNotNull(response.getAccessToken());
    }
}