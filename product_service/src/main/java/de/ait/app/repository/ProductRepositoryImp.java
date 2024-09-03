package de.ait.app.repository;

import de.ait.app.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductRepositoryImp implements ProductRepository {
    List<Product> db = List.of (
            new Product(1L,"Banana",new BigDecimal("1.99"),"art1"),
            new Product(2L,"Kiwi",new BigDecimal("2.99"),"art2"),
            new Product(3L,"Apple",new BigDecimal("3.99"),"art3"),
            new Product(4L,"Pineapple",new BigDecimal("5.99"),"art4")
    );

    @Override
    public List<Product> findAll() {
        return db;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void delete(Product product) {

    }
}
