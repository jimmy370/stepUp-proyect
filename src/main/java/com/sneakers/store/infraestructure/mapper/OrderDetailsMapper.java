package com.sneakers.store.infraestructure.mapper;

import com.sneakers.store.domain.model.DetailsOrder;
import com.sneakers.store.infraestructure.entity.DetailsOrderEntity;
import org.mapstruct.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public interface OrderDetailsMapper {

    DetailsOrderEntity toDetailsOrderEntity(DetailsOrder detailsOrder);
}
