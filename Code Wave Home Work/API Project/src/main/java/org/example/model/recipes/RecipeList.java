package org.example.model.recipes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RecipeList {

    private List<Recipe> recipes;
    private int total;
    private int skip;
    private int limit;
}