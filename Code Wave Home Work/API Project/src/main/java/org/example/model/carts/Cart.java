package org.example.model.carts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Cart {

    private Integer id;

    private List<CartProduct> products;

    private Double total;

    private Integer discountedTotal;

    private Integer userId;

    private Integer totalProducts;

    private Integer totalQuantity;

}
