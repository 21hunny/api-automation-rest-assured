package tests.api.posts;

import org.example.model.posts.GetPostEndpointData;
import org.example.model.posts.Post;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class DeletePostApiTest extends BasePostApiTest {

    @Test(description = "DELETE /posts/{id} deletes a post")
    public void deletePost() {

        GetPostEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "posts/get-post.json",
                        GetPostEndpointData.class);

        Post post =
                postApiClient.deletePost(endpointData.getId());

        assertEquals(post.getId(), endpointData.getId());
    }
}