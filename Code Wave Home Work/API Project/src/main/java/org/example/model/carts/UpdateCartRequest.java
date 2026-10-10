package org.example.model.carts;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UpdateCartRequest {
    private Boolean merge;
    private List<CartProductRequest> products;
}
