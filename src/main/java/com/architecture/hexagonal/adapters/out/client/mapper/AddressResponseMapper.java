package com.architecture.hexagonal.adapters.out.client.mapper;

import com.architecture.hexagonal.adapters.out.client.response.AddressResponse;
import com.architecture.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
