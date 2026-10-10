package org.example.clients;

import org.example.constants.Endpoint;
import org.example.model.posts.*;
import org.example.specifications.posts.PostSpecifications;

import static io.restassured.RestAssured.given;

public class PostApiClient {

    public PostList getAllPosts() {

        return given()
                .spec(PostSpecifications.baseRequestSpec())
                .when()
                .get(Endpoint.POSTS)
                .then()
                .spec(PostSpecifications.okResponseSpec())
                .extract()
                .as(PostList.class);
    }

    public Post getPostById(int postId) {

        return given()
                .spec(PostSpecifications.baseRequestSpec())
                .pathParam("id", postId)
                .when()
                .get(Endpoint.POST_BY_ID)
                .then()
                .spec(PostSpecifications.okResponseSpec())
                .extract()
                .as(Post.class);
    }

    public Post addPost(AddPostRequest request) {

        return given()
                .spec(PostSpecifications.baseRequestSpec())
                .body(request)
                .when()
                .post(Endpoint.ADD_POST)
                .then()
                .spec(PostSpecifications.createdResponseSpec())
                .extract()
                .as(Post.class);
    }

    public Post updatePost(int postId, UpdatePostRequest request) {

        return given()
                .spec(PostSpecifications.baseRequestSpec())
                .pathParam("id", postId)
                .body(request)
                .when()
                .put(Endpoint.POST_BY_ID)
                .then()
                .spec(PostSpecifications.okResponseSpec())
                .extract()
                .as(Post.class);
    }

    public Post deletePost(int postId) {

        return given()
                .spec(PostSpecifications.baseRequestSpec())
                .pathParam("id", postId)
                .when()
                .delete(Endpoint.POST_BY_ID)
                .then()
                .spec(PostSpecifications.okResponseSpec())
                .extract()
                .as(Post.class);
    }
}