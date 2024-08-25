package de.ait.shop43.product.dto;

import lombok.*;


import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private boolean active;
}
