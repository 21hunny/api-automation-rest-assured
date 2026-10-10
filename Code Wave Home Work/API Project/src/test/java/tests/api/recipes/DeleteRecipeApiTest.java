package tests.api.recipes;

import org.example.model.recipes.*;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class DeleteRecipeApiTest extends BaseRecipeApiTest{

    @Test
    public void deleteRecipe(){

        GetRecipeEndpointData data=
                TestDataManager.readTestDataAsObject(
                        "recipes/get-recipe.json",
                        GetRecipeEndpointData.class);

        Recipe recipe=recipeApiClient.deleteRecipe(data.getId());

        assertEquals(recipe.getId(),data.getId());
    }
}