package tests.api.users;

import org.example.model.users.GetUserEndpointData;
import org.example.model.users.UpdateUserRequest;
import org.example.model.users.User;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class UpdateUserApiTest extends BaseUserApiTest {

    @Test(description = "PUT /users/{id} updates a user")
    public void updateUser() {

        UpdateUserRequest request =
                TestDataManager.readTestDataAsObject(
                        "users/update-user.json",
                        UpdateUserRequest.class);

        GetUserEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "users/get-user.json",
                        GetUserEndpointData.class);

        User user =
                userApiClient.updateUser(endpointData.getId(), request);

        assertEquals(user.getId(), endpointData.getId());
        assertEquals(user.getFirstName(), request.getFirstName());
        assertEquals(user.getAge(), request.getAge());
    }

}