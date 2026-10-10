package tests.api.posts;

import org.example.model.posts.GetPostEndpointData;
import org.example.model.posts.Post;
import org.example.model.posts.UpdatePostRequest;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class UpdatePostApiTest extends BasePostApiTest {

    @Test(description = "PUT /posts/{id} updates a post")
    public void updatePost() {

        UpdatePostRequest request =
                TestDataManager.readTestDataAsObject(
                        "posts/update-post.json",
                        UpdatePostRequest.class);

        GetPostEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "posts/get-post.json",
                        GetPostEndpointData.class);

        Post post =
                postApiClient.updatePost(endpointData.getId(), request);

        assertEquals(post.getId(), endpointData.getId());
        assertEquals(post.getTitle(), request.getTitle());
        assertEquals(post.getBody(), request.getBody());
    }
}