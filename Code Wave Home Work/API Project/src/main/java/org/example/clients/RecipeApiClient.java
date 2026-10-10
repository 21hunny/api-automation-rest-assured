package org.example.clients;

import org.example.constants.Endpoint;
import org.example.model.recipes.AddRecipeRequest;
import org.example.model.recipes.Recipe;
import org.example.model.recipes.RecipeList;
import org.example.model.recipes.UpdateRecipeRequest;
import org.example.specifications.recipes.RecipeSpecifications;

import static io.restassured.RestAssured.given;

public class RecipeApiClient {

    // Get all recipes
    public RecipeList getAllRecipes() {

        return given()
                .spec(RecipeSpecifications.baseRequestSpec())
                .when()
                .get(Endpoint.RECIPES)
                .then()
                .spec(RecipeSpecifications.okResponseSpec())
                .extract()
                .as(RecipeList.class);
    }

    // Get recipe by ID
    public Recipe getRecipeById(int id) {

        return given()
                .spec(RecipeSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoint.RECIPE_BY_ID)
                .then()
                .spec(RecipeSpecifications.okResponseSpec())
                .extract()
                .as(Recipe.class);
    }

    // Add recipe
    public Recipe addRecipe(AddRecipeRequest request) {

        return given()
                .spec(RecipeSpecifications.baseRequestSpec())
                .body(request)
                .when()
                .post(Endpoint.ADD_RECIPE)
                .then()
                .spec(RecipeSpecifications.okResponseSpec())   // Changed from createdResponseSpec()
                .extract()
                .as(Recipe.class);
    }

    // Update recipe
    public Recipe updateRecipe(int id, UpdateRecipeRequest request) {

        return given()
                .spec(RecipeSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .body(request)
                .when()
                .put(Endpoint.RECIPE_BY_ID)
                .then()
                .spec(RecipeSpecifications.okResponseSpec())
                .extract()
                .as(Recipe.class);
    }

    // Delete recipe
    public Recipe deleteRecipe(int id) {

        return given()
                .spec(RecipeSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .when()
                .delete(Endpoint.RECIPE_BY_ID)
                .then()
                .spec(RecipeSpecifications.okResponseSpec())
                .extract()
                .as(Recipe.class);
    }
}