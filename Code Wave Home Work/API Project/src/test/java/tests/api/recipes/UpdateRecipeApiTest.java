package tests.api.recipes;

import org.example.model.recipes.*;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class UpdateRecipeApiTest extends BaseRecipeApiTest{

    @Test
    public void updateRecipe(){

        UpdateRecipeRequest request=
                TestDataManager.readTestDataAsObject(
                        "recipes/update-recipe.json",
                        UpdateRecipeRequest.class);

        GetRecipeEndpointData data=
                TestDataManager.readTestDataAsObject(
                        "recipes/get-recipe.json",
                        GetRecipeEndpointData.class);

        Recipe recipe=recipeApiClient.updateRecipe(data.getId(),request);

        assertEquals(recipe.getId(),data.getId());
        assertEquals(recipe.getName(),request.getName());
    }
}