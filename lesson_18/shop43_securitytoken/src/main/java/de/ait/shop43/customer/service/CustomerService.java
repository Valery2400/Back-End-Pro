package de.ait.shop43.customer.service;

import de.ait.shop43.customer.dto.CustomerRequestDto;
import de.ait.shop43.customer.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);
    public List<CustomerResponseDto> getAllCustomers();
    public CustomerResponseDto getCustomerById (Long id);
    public CustomerResponseDto addProductToCart (Long customerId, Long productId);
    public CustomerResponseDto removeProductFromCart (Long customerId, Long productId);
    public CustomerResponseDto changeStatus (Long id, boolean active);


}
