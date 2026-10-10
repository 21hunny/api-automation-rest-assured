package org.example.specifications.todos;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.utils.ConfigManager;

public class TodoSpecifications {

    public static RequestSpecification baseRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getBaseUri())
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification okResponseSpec() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification createdResponseSpec() {

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
}