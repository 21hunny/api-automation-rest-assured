package org.example.clients;

import org.example.constants.Endpoint;
import org.example.model.comments.*;
import org.example.specifications.comments.CommentSpecifications;

import static io.restassured.RestAssured.given;

public class CommentApiClient {

    public CommentList getAllComments() {
        return given()
                .spec(CommentSpecifications.baseRequestSpec())
                .when()
                .get(Endpoint.COMMENTS)
                .then()
                .spec(CommentSpecifications.okResponseSpec())
                .extract()
                .as(CommentList.class);
    }

    public Comment getCommentById(int commentId) {
        return given()
                .spec(CommentSpecifications.baseRequestSpec())
                .pathParam("id", commentId)
                .when()
                .get(Endpoint.COMMENT_BY_ID)
                .then()
                .spec(CommentSpecifications.okResponseSpec())
                .extract()
                .as(Comment.class);
    }

    public Comment addComment(AddCommentRequest request) {
        return given()
                .spec(CommentSpecifications.baseRequestSpec())
                .body(request)
                .when()
                .post(Endpoint.ADD_COMMENT)
                .then()
                .spec(CommentSpecifications.createdResponseSpec())
                .extract()
                .as(Comment.class);
    }

    public Comment updateComment(int commentId, UpdateCommentRequest request) {
        return given()
                .spec(CommentSpecifications.baseRequestSpec())
                .pathParam("id", commentId)
                .body(request)
                .when()
                .put(Endpoint.COMMENT_BY_ID)
                .then()
                .spec(CommentSpecifications.okResponseSpec())
                .extract()
                .as(Comment.class);
    }

    public Comment deleteComment(int commentId) {
        return given()
                .spec(CommentSpecifications.baseRequestSpec())
                .pathParam("id", commentId)
                .when()
                .delete(Endpoint.COMMENT_BY_ID)
                .then()
                .spec(CommentSpecifications.okResponseSpec())
                .extract()
                .as(Comment.class);
    }
}