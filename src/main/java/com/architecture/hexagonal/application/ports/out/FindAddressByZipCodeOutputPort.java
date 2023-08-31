package com.architecture.hexagonal.application.ports.out;

import com.architecture.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}
