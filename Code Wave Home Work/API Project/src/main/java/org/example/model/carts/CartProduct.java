package org.example.model.carts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartProduct {

    private Integer id;

    private String title;

    private Double price;

    private Integer quantity;

    private Double total;

    private Double discountPercentage;

    private Double discountedTotal;

    private String thumbnail;
}