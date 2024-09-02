package de.ait.shop43.product.service;


import de.ait.shop43.product.dto.RequestProductDTO;
import de.ait.shop43.product.dto.ResponseProductDTO;
import de.ait.shop43.product.entity.Product;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProductService {
    List<ResponseProductDTO> findAll();

    public ResponseProductDTO save(ResponseProductDTO dto);

    @Transactional
    ResponseProductDTO update(Long id, RequestProductDTO dto);

    ResponseProductDTO updateActiveStatus(Long productId, boolean active);

    List<ResponseProductDTO> findByTitle(String title);

    Product findProductById(Long id);

    ResponseProductDTO findById (Long id);
}
