package org.example.model.todos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTodoRequest {

    private String todo;
    private Boolean completed;
}