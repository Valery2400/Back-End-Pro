package de.ait.shop43.customer.service;


import de.ait.shop43.cart.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // из каких соображений тут именно такая аннотация?
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper modelMapper;
}
