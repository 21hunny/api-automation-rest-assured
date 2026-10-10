package tests.api.posts;

import org.example.model.posts.GetPostEndpointData;
import org.example.model.posts.Post;
import org.example.model.posts.PostList;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class GetPostTest extends BasePostApiTest {

    @Test(description = "GET /posts returns post list")
    public void getAllPosts() {

        PostList response = postApiClient.getAllPosts();

        assertNotNull(response.getPosts());
        assertFalse(response.getPosts().isEmpty());
        assertTrue(response.getTotal() > 0);
        assertTrue(response.getLimit() > 0);
        assertTrue(response.getSkip() >= 0);
    }

    @Test(description = "GET /posts/{id} returns specific post")
    public void getPostById() {

        GetPostEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "posts/get-post.json",
                        GetPostEndpointData.class);

        Post post = postApiClient.getPostById(endpointData.getId());

        assertEquals(post.getId(), endpointData.getId());
        assertNotNull(post.getTitle());
        assertNotNull(post.getBody());
        assertTrue(post.getUserId() > 0);
    }
}