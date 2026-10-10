package org.example.model.comments;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCommentRequest {

    private String body;
    private Integer postId;
    private Integer userId;

}