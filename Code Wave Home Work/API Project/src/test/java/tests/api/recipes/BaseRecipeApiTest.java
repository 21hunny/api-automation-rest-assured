package tests.api.recipes;

import org.example.clients.RecipeApiClient;
import org.testng.annotations.*;

public class BaseRecipeApiTest {

    protected RecipeApiClient recipeApiClient;

    @BeforeClass
    public void setUp(){

        recipeApiClient=new RecipeApiClient();
    }

    @BeforeMethod
    public void beforeMethod(){

        System.out.println("===== Before Method =====");
    }

    @AfterMethod
    public void afterMethod(){

        System.out.println("===== After Method =====");
    }

    @AfterTest
    public void cleanUp(){

        System.out.println("===== Clean Up =====");
    }
}