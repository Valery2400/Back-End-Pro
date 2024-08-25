package de.ait.shop43.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class RequestProductDTO {
    private String title;
    private BigDecimal price;
}
