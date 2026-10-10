package org.example.model.posts;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePostRequest {

    private String title;
    private String body;

}