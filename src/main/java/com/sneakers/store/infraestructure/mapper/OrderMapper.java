package com.sneakers.store.infraestructure.mapper;

import com.sneakers.store.domain.model.Order;
import com.sneakers.store.infraestructure.entity.OrderEntity;
import org.mapstruct.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public interface OrderMapper {

    OrderEntity toOrderEntity(Order order);


}
