package de.ait.shop43.product.controller;

import de.ait.shop43.product.dto.RequestProductDTO;
import de.ait.shop43.product.dto.ResponseProductDTO;
import de.ait.shop43.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService service;

    //localhost:8080/products
    //localhost:8080/products?title=milk


    @GetMapping("/products")
    public List<ResponseProductDTO> getProducts(@RequestParam(name = "title", required = false, defaultValue = "") String title) {
        if (title.isEmpty()){
            return service.findAll();
        } else {
            return service.findByTitle(title);
        }
    }

    @PostMapping("/products")
    public ResponseProductDTO createProduct(@RequestBody ResponseProductDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/products/{id}")
    public ResponseProductDTO updateProduct(@RequestBody RequestProductDTO dto, @PathVariable Long id) {
        return service.update(id, dto);
    }

    //PATCH products/3?active=true
    @PatchMapping("/products/{id}")
    public ResponseProductDTO setActive(@PathVariable(name = "id") Long productId,
                                        @RequestParam(name = "active", required = true) boolean active) {

        return this.service.updateActiveStatus(productId, active);
    }
    @GetMapping ("/products/{id}")
    public ResponseProductDTO findById(@PathVariable(name = "id") Long id) {
        return this.service.findById(id);
    }
}
