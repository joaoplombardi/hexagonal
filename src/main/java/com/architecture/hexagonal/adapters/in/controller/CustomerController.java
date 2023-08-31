package com.architecture.hexagonal.adapters.in.controller;

import com.architecture.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.architecture.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.architecture.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper mapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CustomerRequest customerRequest) {
        var customer = mapper.toCustomer(customerRequest);

        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());

        return ResponseEntity.ok().build();
    }

}
