package org.example.model.posts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

    private Integer id;
    private String title;
    private String body;
    private Integer userId;

}