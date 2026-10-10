package org.example.model.users;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserList {

    private List<User> users;
    private int total;
    private int skip;
    private int limit;

}