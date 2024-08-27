package de.ait.shop43.customer.dto;

import de.ait.shop43.cart.entity.Cart;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder




public class CustomerRequestDto {

    private Long id;

    private String name;

    private boolean active;



    private Cart cart;
}
