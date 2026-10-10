package tests.api.users;

import org.example.model.users.GetUserEndpointData;
import org.example.model.users.User;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class DeleteUserApiTest extends BaseUserApiTest {

    @Test(description = "DELETE /users/{id} deletes a user")
    public void deleteUser() {

        GetUserEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "users/get-user.json",
                        GetUserEndpointData.class);

        User user =
                userApiClient.deleteUser(endpointData.getId());

        assertEquals(user.getId(), endpointData.getId());

    }

}