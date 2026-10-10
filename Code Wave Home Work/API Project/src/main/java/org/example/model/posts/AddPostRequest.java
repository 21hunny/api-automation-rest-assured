package org.example.model.posts;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddPostRequest {

    private String title;
    private String body;
    private Integer userId;

}