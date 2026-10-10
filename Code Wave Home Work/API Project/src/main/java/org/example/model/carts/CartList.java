package org.example.model.carts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CartList {

    private List<Cart> carts;
    private int total;
    private int skip;
    private int limit;

}