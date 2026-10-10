package org.example.model.todos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {

    private Integer id;
    private String todo;
    private Boolean completed;
    private Integer userId;
}