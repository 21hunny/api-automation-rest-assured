package org.example.model.products;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductList {

    private List<Product> products;
    private int total;
    private int skip;
    private int limit;
}