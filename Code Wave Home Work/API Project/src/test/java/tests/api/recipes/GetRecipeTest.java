package tests.api.recipes;

import org.example.model.recipes.*;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class GetRecipeTest extends BaseRecipeApiTest{

    @Test
    public void getAllRecipes(){

        RecipeList response=recipeApiClient.getAllRecipes();

        assertNotNull(response.getRecipes());
        assertFalse(response.getRecipes().isEmpty());
        assertTrue(response.getTotal()>0);
    }

    @Test
    public void getRecipeById(){

        GetRecipeEndpointData data=
                TestDataManager.readTestDataAsObject(
                        "recipes/get-recipe.json",
                        GetRecipeEndpointData.class);

        Recipe recipe=recipeApiClient.getRecipeById(data.getId());

        assertEquals(recipe.getId(),data.getId());
        assertNotNull(recipe.getName());
        assertNotNull(recipe.getCuisine());
    }
}