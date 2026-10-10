package org.example.model.products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProductRequest {

    private String title;
    private Double price;
    private String category;
}