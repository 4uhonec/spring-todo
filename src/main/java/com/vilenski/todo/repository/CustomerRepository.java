package com.vilenski.todo.repository;

import com.vilenski.todo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findCustomerByEmail(String email);
    Optional<Customer> findCustomerById(UUID id);

    Customer findByUsername(String username);
}
