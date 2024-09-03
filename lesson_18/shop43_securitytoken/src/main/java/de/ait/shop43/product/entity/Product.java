package de.ait.shop43.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Builder    // !!! create pattern Builder
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="active")
    private boolean active;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
