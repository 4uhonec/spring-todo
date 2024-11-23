package com.vilenski.todo.mapper;

import com.vilenski.todo.dto.CustomerDTO;
import com.vilenski.todo.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDTOMapper {

    public Customer mapToCustomer(CustomerDTO customerDTO) {
        return Customer.builder().build();
    }

    public CustomerDTO mapToCustomerDTO(Customer customer) {
        return CustomerDTO.builder().build();
    }

}
