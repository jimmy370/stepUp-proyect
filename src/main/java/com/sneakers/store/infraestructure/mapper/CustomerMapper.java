package com.sneakers.store.infraestructure.mapper;

import com.sneakers.store.domain.dto.CustomerDto;
import com.sneakers.store.domain.dto.DetailsDto;
import com.sneakers.store.domain.dto.InvoiceDto;
import com.sneakers.store.domain.dto.OrderDto;
import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.model.DetailsOrder;
import com.sneakers.store.domain.model.Invoice;
import com.sneakers.store.domain.model.Order;
import com.sneakers.store.infraestructure.entity.CustomerEntity;
import com.sneakers.store.infraestructure.entity.DetailsOrderEntity;
import com.sneakers.store.infraestructure.entity.InvoiceEntity;
import com.sneakers.store.infraestructure.entity.OrderEntity;
import org.mapstruct.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

    CustomerDto fromCustomer(Customer customer);

    @Mapping(target = "customer", ignore = true)
    Order toOrderDto(OrderEntity entity);

    @Mapping(target = "order", ignore = true)
    DetailsOrder toDetailsOrder(DetailsOrderEntity entity);

    @Mapping(target = "order", ignore = true)
    Invoice toInvoice(InvoiceEntity InvoiceEntity);


    CustomerDto toCustomerDto(CustomerEntity entity);

}
