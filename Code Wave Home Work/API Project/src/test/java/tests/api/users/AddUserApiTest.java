package tests.api.users;

import org.example.model.users.AddUserRequest;
import org.example.model.users.User;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class AddUserApiTest extends BaseUserApiTest {

    @Test(description = "POST /users/add adds a new user")
    public void addUser() {

        AddUserRequest request =
                TestDataManager.readTestDataAsObject(
                        "users/add-user.json",
                        AddUserRequest.class);

        User user = userApiClient.addUser(request);

        assertTrue(user.getId() > 0);
        assertEquals(user.getFirstName(), request.getFirstName());
        assertEquals(user.getAge(), request.getAge());
    }

}