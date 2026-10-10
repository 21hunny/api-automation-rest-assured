package org.example.specifications.images;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.utils.ConfigManager;

public class ImageSpecifications {

    public static RequestSpecification baseRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getBaseUri())
                .build();
    }

    public static ResponseSpecification okResponseSpec() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}