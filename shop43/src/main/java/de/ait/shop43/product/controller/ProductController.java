package de.ait.shop43.product.controller;

import de.ait.shop43.product.dto.ResponseProductDTO;
import de.ait.shop43.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService service;

   @GetMapping("/products")
    public List<ResponseProductDTO> getProducts() {
        service.findAll();
        return service.findAll();
    }

    @PostMapping("/products")
    public ResponseProductDTO createProduct(@RequestBody ResponseProductDTO dto) {
       return service.save(dto);
   }

    @PutMapping("/products/{id}")
    public ResponseProductDTO updateProduct(@RequestBody ResponseProductDTO dto, @PathVariable Long id) {
        return service.update(id,dto);
    }
}
