package org.example.model.recipes;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddRecipeRequest {

    private String name;
    private String cuisine;
    private String difficulty;
}