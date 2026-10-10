package tests.api.todos;

import org.example.model.todos.GetTodoEndpointData;
import org.example.model.todos.Todo;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class DeleteTodoApiTest extends BaseTodoApiTest {

    @Test(description = "DELETE /todos/{id} deletes a todo")
    public void deleteTodo() {

        GetTodoEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "todos/get-todo.json",
                        GetTodoEndpointData.class);

        Todo todo = todoApiClient.deleteTodo(endpointData.getId());

        assertEquals(todo.getId(), endpointData.getId());
    }
}