package de.ait.shop43.customer.controller;

import de.ait.shop43.customer.dto.CustomerRequestDto;
import de.ait.shop43.customer.dto.CustomerResponseDto;
import de.ait.shop43.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // тот же вопрос
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    public CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        return service.createCustomer(customerRequestDto);
    }

    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {
        return service.getAllCustomers();
    }
    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable(name = "id" ) Long id) {

        return service.getCustomerById(id);
    }
    @PutMapping("/{customerId}/products/{productId}")
    public CustomerResponseDto addProductToCart(@PathVariable(name="customerId") Long customerId,
                                                @PathVariable(name = "productId") Long productId) {
        return service.addProductToCart(customerId, productId);
    }

    @DeleteMapping("/{customerId}/products/{productId}")
    public CustomerResponseDto removeProductFromCart(@PathVariable(name="customerId") Long customerId,
                                                     @PathVariable(name = "productId") Long productId) {
        return service.removeProductFromCart(customerId, productId);
    }

    @PatchMapping("/{id}")
    public CustomerResponseDto changeStatus(@PathVariable (name = "id") Long id,
                                            @RequestParam (name = "active", defaultValue = "true")
                                            boolean active) {
        return service.changeStatus(id, active);
    }

    private final CustomerService service;
}
