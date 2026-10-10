package tests.api.comments;

import org.example.model.comments.Comment;
import org.example.model.comments.CommentList;
import org.example.model.comments.GetCommentEndpointData;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class GetCommentTest extends BaseCommentApiTest {

    @Test(description = "GET /comments returns comment list")
    public void getAllComments() {

        CommentList response = commentApiClient.getAllComments();

        assertNotNull(response.getComments());
        assertFalse(response.getComments().isEmpty());
        assertTrue(response.getTotal() > 0);
        assertTrue(response.getLimit() > 0);
        assertTrue(response.getSkip() >= 0);
    }

    @Test(description = "GET /comments/{id} returns specific comment")
    public void getCommentById() {

        GetCommentEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "comments/get-comment.json",
                        GetCommentEndpointData.class);

        Comment comment = commentApiClient.getCommentById(endpointData.getId());

        assertEquals(comment.getId(), endpointData.getId());
        assertNotNull(comment.getBody());
        assertTrue(comment.getPostId() > 0);
    }
}