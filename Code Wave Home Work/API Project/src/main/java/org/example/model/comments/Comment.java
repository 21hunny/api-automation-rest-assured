package org.example.model.comments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    private Integer id;
    private String body;
    private Integer postId;
    private Integer likes;
    private Integer userId;

}