package org.example.model.recipes;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateRecipeRequest {

    private String name;
    private String difficulty;
}