package tests.api.posts;

import org.example.model.posts.AddPostRequest;
import org.example.model.posts.Post;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class AddPostApiTest extends BasePostApiTest {

    @Test(description = "POST /posts/add adds a new post")
    public void addPost() {

        AddPostRequest request =
                TestDataManager.readTestDataAsObject(
                        "posts/add-post.json",
                        AddPostRequest.class);

        Post post = postApiClient.addPost(request);

        assertTrue(post.getId() > 0);
        assertEquals(post.getTitle(), request.getTitle());
        assertEquals(post.getBody(), request.getBody());
        assertEquals(post.getUserId(), request.getUserId());
    }
}