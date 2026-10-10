package org.example.clients;

import org.example.constants.Endpoint;
import org.example.model.todos.AddTodoRequest;
import org.example.model.todos.Todo;
import org.example.model.todos.TodoList;
import org.example.model.todos.UpdateTodoRequest;
import org.example.specifications.todos.TodoSpecifications;

import static io.restassured.RestAssured.given;

public class TodoApiClient {

    public TodoList getAllTodos() {

        return given()
                .spec(TodoSpecifications.baseRequestSpec())
                .when()
                .get(Endpoint.TODOS)
                .then()
                .spec(TodoSpecifications.okResponseSpec())
                .extract()
                .as(TodoList.class);
    }

    public Todo getTodoById(int id) {

        return given()
                .spec(TodoSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoint.TODO_BY_ID)
                .then()
                .spec(TodoSpecifications.okResponseSpec())
                .extract()
                .as(Todo.class);
    }

    public Todo addTodo(AddTodoRequest request) {

        return given()
                .spec(TodoSpecifications.baseRequestSpec())
                .body(request)
                .when()
                .post(Endpoint.ADD_TODO)
                .then()
                .spec(TodoSpecifications.createdResponseSpec())
                .extract()
                .as(Todo.class);
    }

    public Todo updateTodo(int id, UpdateTodoRequest request) {

        return given()
                .spec(TodoSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .body(request)
                .when()
                .put(Endpoint.TODO_BY_ID)
                .then()
                .spec(TodoSpecifications.okResponseSpec())
                .extract()
                .as(Todo.class);
    }

    public Todo deleteTodo(int id) {

        return given()
                .spec(TodoSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .when()
                .delete(Endpoint.TODO_BY_ID)
                .then()
                .spec(TodoSpecifications.okResponseSpec())
                .extract()
                .as(Todo.class);
    }
}