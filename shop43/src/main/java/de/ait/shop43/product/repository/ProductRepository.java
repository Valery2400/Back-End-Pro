package de.ait.shop43.product.repository;

import de.ait.shop43.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//JpaRepository<Product, Long> - Product - тип сущности Long - тип ID
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);

}

