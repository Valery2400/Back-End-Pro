package de.ait.shop43.customer.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class CustomerResponseDto {


    private Long id;

    private String name;

    private boolean active;


    private CartResponceDto cart;
}
