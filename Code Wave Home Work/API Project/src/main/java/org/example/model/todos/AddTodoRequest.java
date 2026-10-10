package org.example.model.todos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTodoRequest {

    private String todo;
    private Boolean completed;
    private Integer userId;
}