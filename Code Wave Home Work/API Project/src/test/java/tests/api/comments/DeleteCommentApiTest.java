package tests.api.comments;

import org.example.model.comments.Comment;
import org.example.model.comments.GetCommentEndpointData;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class DeleteCommentApiTest extends BaseCommentApiTest {

    @Test(description = "DELETE /comments/{id} deletes a comment")
    public void deleteComment() {

        GetCommentEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "comments/get-comment.json",
                        GetCommentEndpointData.class);

        Comment comment =
                commentApiClient.deleteComment(endpointData.getId());

        assertEquals(comment.getId(), endpointData.getId());
    }
}