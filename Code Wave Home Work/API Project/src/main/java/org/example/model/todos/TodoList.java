package org.example.model.todos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TodoList {

    private List<Todo> todos;
    private int total;
    private int skip;
    private int limit;
}