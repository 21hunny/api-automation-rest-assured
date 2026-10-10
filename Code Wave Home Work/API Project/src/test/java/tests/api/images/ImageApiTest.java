package tests.api.images;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ImageApiTest extends BaseImageApiTest {

    @Test(description = "Generate square image")
    public void generateSquareImage() {

        Response response =
                imageApiClient.generateSquareImage(150);

        assertEquals(response.statusCode(), 200);
        assertTrue(
                response.getContentType().contains("image"));
    }

    @Test(description = "Generate custom size image")
    public void generateCustomImage() {

        Response response =
                imageApiClient.generateCustomImage(
                        200,
                        100);

        assertEquals(response.statusCode(), 200);
        assertTrue(
                response.getContentType().contains("image"));
    }

    @Test(description = "Generate image with text")
    public void generateImageWithText() {

        Response response =
                imageApiClient.generateImageWithText(
                        400,
                        200,
                        "Hello");

        assertEquals(response.statusCode(), 200);
        assertTrue(
                response.getContentType().contains("image"));
    }

    @Test(description = "Generate identicon")
    public void generateIcon() {

        Response response =
                imageApiClient.generateIcon(
                        "abc123",
                        150);

        assertEquals(response.statusCode(), 200);
        assertTrue(
                response.getContentType().contains("image"));
    }
}