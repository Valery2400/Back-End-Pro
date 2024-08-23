package de.ait.shop43.product.entity;

import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode
@Builder    // !!! create pattern Builder
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private boolean active;
}
