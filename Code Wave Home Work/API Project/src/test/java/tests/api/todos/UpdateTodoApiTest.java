package tests.api.todos;

import org.example.model.todos.GetTodoEndpointData;
import org.example.model.todos.Todo;
import org.example.model.todos.UpdateTodoRequest;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class UpdateTodoApiTest extends BaseTodoApiTest {

    @Test(description = "PUT /todos/{id} updates a todo")
    public void updateTodo() {

        UpdateTodoRequest request =
                TestDataManager.readTestDataAsObject(
                        "todos/update-todo.json",
                        UpdateTodoRequest.class);

        GetTodoEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "todos/get-todo.json",
                        GetTodoEndpointData.class);

        Todo todo =
                todoApiClient.updateTodo(
                        endpointData.getId(),
                        request);

        assertEquals(todo.getId(), endpointData.getId());
        assertEquals(todo.getTodo(), request.getTodo());
    }
}