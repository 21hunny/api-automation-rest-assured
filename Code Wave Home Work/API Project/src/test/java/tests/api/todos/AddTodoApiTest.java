package tests.api.todos;

import org.example.model.todos.AddTodoRequest;
import org.example.model.todos.Todo;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class AddTodoApiTest extends BaseTodoApiTest {

    @Test(description = "POST /todos/add adds a new todo")
    public void addTodo() {

        AddTodoRequest request =
                TestDataManager.readTestDataAsObject(
                        "todos/add-todo.json",
                        AddTodoRequest.class);

        Todo todo = todoApiClient.addTodo(request);

        assertTrue(todo.getId() > 0);
        assertEquals(todo.getTodo(), request.getTodo());
    }
}