package com.architecture.hexagonal.adapters.out.repository.mapper;

import com.architecture.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.architecture.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

}
