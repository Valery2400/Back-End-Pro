package de.ait.shop43.cart.entity;

import de.ait.shop43.customer.entity.Customer;
import de.ait.shop43.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn (name = "cart_id"),
            inverseJoinColumns = @JoinColumn (name = "product_id")


    )
    private List<Product> products;


}
