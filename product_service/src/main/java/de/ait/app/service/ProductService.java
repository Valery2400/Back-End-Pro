package de.ait.app.service;

import de.ait.app.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductId(Long id);

    Product getAllProduct(Long id);

    Product save(Product product);


}
