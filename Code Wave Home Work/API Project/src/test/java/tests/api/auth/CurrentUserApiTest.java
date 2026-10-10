package tests.api.auth;

import org.example.model.auth.CurrentUser;
import org.example.model.auth.LoginRequest;
import org.example.model.auth.LoginResponse;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class CurrentUserApiTest extends BaseAuthApiTest {

    @Test(description = "GET /auth/me")
    public void currentUser() {

        LoginRequest request =
                TestDataManager.readTestDataAsObject(
                        "auth/login.json",
                        LoginRequest.class);

        LoginResponse login =
                authApiClient.login(request);

        CurrentUser user =
                authApiClient.getCurrentUser(
                        login.getAccessToken());

        assertEquals(user.getUsername(), request.getUsername());
        assertNotNull(user.getEmail());
    }
}