package de.ait.app.service;

import de.ait.app.entity.Product;
import de.ait.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    @Override
    public Product getProductId(Long id) {
        return null;
    }

    @Override
    public Product getAllProduct(Long id) {
        return repository.findAll()
                .stream()
                .filter(p->p.getId().equals(id))
                .findAny()
                .get();
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
