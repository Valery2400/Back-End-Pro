package de.ait.shop43.product.service;

import de.ait.shop43.product.dto.ResponseProductDTO;
import de.ait.shop43.product.entity.Product;
import de.ait.shop43.product.repository.ProductRepository;
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
}
