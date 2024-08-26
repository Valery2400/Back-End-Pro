package de.ait.shop43.product.repository;

import de.ait.shop43.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


//JpaRepository<Product, Long> - Product - тип сущности Long - тип ID
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
    //List<Product> findByTitleAndActive(String title, boolean active); //where product.title = title and product.active = active
    //List<Product> findByTitleOrActive(String title, boolean active); //where product.title = title or product.active = active
    Product findFirstByTitleOrderById(String title);
    List<Product> findAllByTitleIn(List<String> titles);
    List<Product> findAllByPriceLessThan(BigDecimal price);
    List<Product> findAllByPriceGreaterThan(BigDecimal price);




}

