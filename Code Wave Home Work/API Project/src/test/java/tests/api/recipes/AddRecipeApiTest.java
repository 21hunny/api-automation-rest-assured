package tests.api.recipes;

import org.example.model.recipes.AddRecipeRequest;
import org.example.model.recipes.Recipe;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class AddRecipeApiTest extends BaseRecipeApiTest {

    @Test(description = "POST /recipes/add adds a new recipe")
    public void addRecipe() {

        AddRecipeRequest request =
                TestDataManager.readTestDataAsObject(
                        "recipes/add-recipe.json",
                        AddRecipeRequest.class);

        Recipe recipe = recipeApiClient.addRecipe(request);

        assertTrue(recipe.getId() > 0);
        assertEquals(recipe.getName(), request.getName());
    }
}