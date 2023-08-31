package com.architecture.hexagonal.adapters.out;

import com.architecture.hexagonal.adapters.out.repository.CustomerRepository;
import com.architecture.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.architecture.hexagonal.application.core.domain.Customer;
import com.architecture.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper mapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = mapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
