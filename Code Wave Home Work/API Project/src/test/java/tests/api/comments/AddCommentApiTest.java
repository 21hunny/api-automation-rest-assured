package tests.api.comments;

import org.example.model.comments.AddCommentRequest;
import org.example.model.comments.Comment;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class AddCommentApiTest extends BaseCommentApiTest {

    @Test(description = "POST /comments/add adds a new comment")
    public void addComment() {

        AddCommentRequest request =
                TestDataManager.readTestDataAsObject(
                        "comments/add-comment.json",
                        AddCommentRequest.class);

        Comment comment = commentApiClient.addComment(request);

        assertTrue(comment.getId() > 0);
        assertEquals(comment.getBody(), request.getBody());
        assertEquals(comment.getPostId(), request.getPostId());
    }
}