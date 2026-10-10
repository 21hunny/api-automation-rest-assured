package org.example.model.posts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PostList {

    private List<Post> posts;
    private int total;
    private int skip;
    private int limit;

}