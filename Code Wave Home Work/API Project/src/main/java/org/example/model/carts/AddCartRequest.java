package org.example.model.carts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AddCartRequest {
    private Integer userId;

    private List<CartProductRequest> products;

}
