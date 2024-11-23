package com.vilenski.todo.service;

import com.vilenski.todo.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    Customer saveNewCustomer(Customer customer);
    Optional<Customer> getCustomerById(UUID id);
    List<Customer> getAllCustomers();
    Boolean deleteCustomerById(UUID id);
    Customer updateCustomerById(UUID customerId, Customer customer);

}
