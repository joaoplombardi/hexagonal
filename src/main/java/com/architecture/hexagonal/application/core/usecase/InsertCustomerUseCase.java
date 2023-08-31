package com.architecture.hexagonal.application.core.usecase;

import com.architecture.hexagonal.application.core.domain.Customer;
import com.architecture.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.architecture.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerOutputPort{

    public InsertCustomerUseCase(
        FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
        InsertCustomerOutputPort insertCustomerOutputPort
    ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);

        insertCustomerOutputPort.insert(customer);
    }

    @Override
    public void insert(Customer customer) {

    }
}
