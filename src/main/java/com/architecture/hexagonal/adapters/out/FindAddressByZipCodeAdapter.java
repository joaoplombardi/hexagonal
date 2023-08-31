package com.architecture.hexagonal.adapters.out;

import com.architecture.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.architecture.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.architecture.hexagonal.application.core.domain.Address;
import com.architecture.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper mapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return mapper.toAddress(addressResponse);
    }
}
