package tests.api.auth;

import org.example.model.auth.LoginRequest;
import org.example.model.auth.LoginResponse;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class LoginApiTest extends BaseAuthApiTest {

    @Test(description = "POST /auth/login")
    public void login() {

        LoginRequest request =
                TestDataManager.readTestDataAsObject(
                        "auth/login.json",
                        LoginRequest.class);

        LoginResponse response =
                authApiClient.login(request);

        assertNotNull(response.getAccessToken());
        assertNotNull(response.getRefreshToken());
        assertEquals(response.getUsername(), request.getUsername());
    }
}