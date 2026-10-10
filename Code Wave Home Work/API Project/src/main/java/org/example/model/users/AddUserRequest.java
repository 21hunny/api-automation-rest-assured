package org.example.model.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddUserRequest {

    private String firstName;
    private String lastName;
    private Integer age;

}