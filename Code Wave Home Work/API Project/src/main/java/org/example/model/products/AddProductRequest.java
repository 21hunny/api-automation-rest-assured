package org.example.model.products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProductRequest {

    private String title;
    private String description;
    private String category;
    private Double price;
}