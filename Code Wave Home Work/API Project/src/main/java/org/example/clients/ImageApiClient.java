package org.example.clients;

import io.restassured.response.Response;
import org.example.constants.Endpoint;
import org.example.specifications.images.ImageSpecifications;

import static io.restassured.RestAssured.given;

public class ImageApiClient {

    public Response generateSquareImage(int size) {

        return given()
                .spec(ImageSpecifications.baseRequestSpec())
                .pathParam("size", size)
                .when()
                .get(Endpoint.IMAGE);
    }

    public Response generateCustomImage(int width, int height) {

        return given()
                .spec(ImageSpecifications.baseRequestSpec())
                .pathParam("width", width)
                .pathParam("height", height)
                .when()
                .get(Endpoint.CUSTOM_IMAGE);
    }

    public Response generateImageWithText(
            int width,
            int height,
            String text) {

        return given()
                .spec(ImageSpecifications.baseRequestSpec())
                .pathParam("width", width)
                .pathParam("height", height)
                .queryParam("text", text)
                .when()
                .get(Endpoint.CUSTOM_IMAGE);
    }

    public Response generateIcon(String hash, int size) {

        return given()
                .spec(ImageSpecifications.baseRequestSpec())
                .pathParam("hash", hash)
                .pathParam("size", size)
                .when()
                .get(Endpoint.ICON);
    }
}