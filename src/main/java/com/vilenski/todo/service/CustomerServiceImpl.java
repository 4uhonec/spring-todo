package com.vilenski.todo.service;

import com.vilenski.todo.entity.Customer;
import com.vilenski.todo.entity.TaskList;
import com.vilenski.todo.repository.CustomerRepository;
import com.vilenski.todo.repository.TaskListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final TaskListRepository taskListRepository;

    @Override
    public Customer saveNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(UUID id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Boolean deleteCustomerById(UUID id) {
        Customer customer = customerRepository.findCustomerById(id).orElse(null);
        if(customer != null) {
            customerRepository.delete(customer);
            return true;
        }
        return false;
    }

    @Override
    public Customer updateCustomerById(UUID customerId, Customer updatedCustomer) {
        Optional<Customer> customer = customerRepository.findCustomerById(customerId);
        if(customer.isEmpty()){
            throw new RuntimeException("Customer not found");
        }

        return customerRepository.save(updatedCustomer);
    }
}

