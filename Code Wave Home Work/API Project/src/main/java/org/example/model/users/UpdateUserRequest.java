package org.example.model.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserRequest {

    private String firstName;
    private Integer age;

}