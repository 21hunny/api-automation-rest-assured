package tests.api.users;

import org.example.clients.UserApiClient;
import org.example.model.users.GetUserEndpointData;
import org.example.model.users.User;
import org.example.model.users.UserList;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class GetUserTest extends BaseUserApiTest {

    @Test(description = "GET /users returns user list")
    public void getAllUsers() {

        UserList response = userApiClient.getAllUsers();

        assertNotNull(response.getUsers());
        assertFalse(response.getUsers().isEmpty());
        assertTrue(response.getTotal() > 0);
        assertTrue(response.getLimit() > 0);
        assertTrue(response.getSkip() >= 0);
    }

    @Test(description = "GET /users/{id} returns specific user")
    public void getUserById() {

        GetUserEndpointData getUserEndpointData =
                TestDataManager.readTestDataAsObject(
                        "users/get-user.json",
                        GetUserEndpointData.class);

        User user = userApiClient.getUserById(getUserEndpointData.getId());

        assertEquals(user.getId(), getUserEndpointData.getId());
        assertNotNull(user.getFirstName());
        assertNotNull(user.getLastName());
        assertTrue(user.getAge() > 0);
        assertNotNull(user.getEmail());
        assertNotNull(user.getPhone());
        assertNotNull(user.getUsername());
    }
}