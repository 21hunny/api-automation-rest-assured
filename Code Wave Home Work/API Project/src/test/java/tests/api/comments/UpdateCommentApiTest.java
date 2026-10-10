package tests.api.comments;

import org.example.model.comments.Comment;
import org.example.model.comments.GetCommentEndpointData;
import org.example.model.comments.UpdateCommentRequest;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class UpdateCommentApiTest extends BaseCommentApiTest {

    @Test(description = "PUT /comments/{id} updates a comment")
    public void updateComment() {

        UpdateCommentRequest request =
                TestDataManager.readTestDataAsObject(
                        "comments/update-comment.json",
                        UpdateCommentRequest.class);

        GetCommentEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "comments/get-comment.json",
                        GetCommentEndpointData.class);

        Comment comment =
                commentApiClient.updateComment(endpointData.getId(), request);

        assertEquals(comment.getId(), endpointData.getId());
        assertEquals(comment.getBody(), request.getBody());
    }
}