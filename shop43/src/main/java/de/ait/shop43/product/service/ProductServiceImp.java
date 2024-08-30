package de.ait.shop43.product.service;

import de.ait.shop43.exception.ProductNotFoundException;
import de.ait.shop43.product.dto.RequestProductDTO;
import de.ait.shop43.product.dto.ResponseProductDTO;
import de.ait.shop43.product.entity.Product;
import de.ait.shop43.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {


    private final ProductRepository repository;

    private final ModelMapper mapper;

    @Override
    public List<ResponseProductDTO> findAll() {

        return repository.findAll().stream()
                .map(product -> mapper.map(product, ResponseProductDTO.class))
                .toList();
    }

    @Override
    public ResponseProductDTO save(ResponseProductDTO dto) {
        Product entity = mapper.map(dto, Product.class); // RequestProductDTO -> Product
        Product newProduct = repository.save(entity);
        return mapper.map(newProduct, ResponseProductDTO.class); // Product -> ResponseProductDTO
    }

    @Override
    @Transactional
    public ResponseProductDTO update(Long id, RequestProductDTO dto) {
        Product entity = mapper.map(dto, Product.class);
        entity.setId(id);
        entity = repository.save(entity);
        return mapper.map(entity, ResponseProductDTO.class);
    }


    @Override
    @Transactional
    public ResponseProductDTO updateActiveStatus(Long productId, boolean active) {
        Product entity = findProductById(productId);
        entity.setActive(active);
        return mapper.map(entity, ResponseProductDTO.class);
    }

    @Override
    public Product findProductById(Long productId) {
        Product entity = repository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product " + productId + " not found"));
        return entity;
    }
    public ResponseProductDTO findById(Long productId) {

        Product entity = findProductById(productId);
        return mapper.map(entity, ResponseProductDTO.class);

    }

    @Override
    public List<ResponseProductDTO> findByTitle(String title) {
        List<Product> productByTitle = repository.findByTitle(title);
        return productByTitle.stream()
                .map(product -> mapper.map(product, ResponseProductDTO.class))
                .toList();
    }
}
