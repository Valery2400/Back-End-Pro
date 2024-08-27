package de.ait.shop43.cart.controller;

import de.ait.shop43.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor // тот же вопрос
@RestController
public class CustomerController {
    private final CustomerService service;
}
