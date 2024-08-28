package de.ait.shop43.customer.service;


import de.ait.shop43.cart.entity.Cart;
import de.ait.shop43.cart.repository.CustomerRepository;
import de.ait.shop43.customer.dto.CustomerRequestDto;
import de.ait.shop43.customer.dto.CustomerResponseDto;
import de.ait.shop43.customer.entity.Customer;
import de.ait.shop43.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // из каких соображений тут именно такая аннотация?
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto dto) {
        Customer entity = modelMapper.map(dto, Customer.class);
        entity.setActive(true);
        Cart cart = new Cart();
        entity.setCart(cart);   // в этих двух строчках
        cart.setCustomer(entity);// java relations
        entity = repository.save(entity);
        return modelMapper.map(entity, CustomerResponseDto.class);
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(entity -> modelMapper.map(entity, CustomerResponseDto.class))
                .toList();
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        return modelMapper.map(findCustomerById(id), CustomerResponseDto.class);
    }

    private Customer findCustomerById(Long id) {
        String msg = "Customer id " + id + " not found";
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(msg));
        return customer;
    }

    @Override
    public CustomerResponseDto addProductToCart(Long customerId, Long productId) {
        Customer customer = findCustomerById(customerId);
        Cart cart = customer.getCart();

        return null;
    }

    @Override
    public CustomerResponseDto removeProductFromCart(Long customerId, Long productId) {
        return null;
    }

    @Override
    public CustomerResponseDto changeStatus(Long id, Boolean active) {
        return null;
    }
}
