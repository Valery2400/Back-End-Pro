package de.ait.shop43.customer.entity;

import de.ait.shop43.cart.entity.Cart;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private boolean active;


    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;
}
