package tests.api.todos;

import org.example.model.todos.GetTodoEndpointData;
import org.example.model.todos.Todo;
import org.example.model.todos.TodoList;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class GetTodoTest extends BaseTodoApiTest {

    @Test(description = "GET /todos returns todo list")
    public void getAllTodos() {

        TodoList response = todoApiClient.getAllTodos();

        assertNotNull(response.getTodos());
        assertFalse(response.getTodos().isEmpty());
        assertTrue(response.getTotal() > 0);
        assertTrue(response.getLimit() > 0);
        assertTrue(response.getSkip() >= 0);
    }

    @Test(description = "GET /todos/{id} returns specific todo")
    public void getTodoById() {

        GetTodoEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "todos/get-todo.json",
                        GetTodoEndpointData.class);

        Todo todo = todoApiClient.getTodoById(endpointData.getId());

        assertEquals(todo.getId(), endpointData.getId());
        assertNotNull(todo.getTodo());
    }
}