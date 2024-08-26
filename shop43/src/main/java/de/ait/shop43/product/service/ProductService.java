package de.ait.shop43.product.service;


import de.ait.shop43.product.dto.ResponseProductDTO;

import java.util.List;

public interface ProductService {
    List<ResponseProductDTO> findAll();

    public ResponseProductDTO save(ResponseProductDTO dto);

    ResponseProductDTO update(Long id, ResponseProductDTO dto);
}
