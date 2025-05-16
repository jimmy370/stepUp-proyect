package com.sneakers.store.infraestructure.mapper;

import com.sneakers.store.domain.model.Invoice;
import com.sneakers.store.infraestructure.entity.InvoiceEntity;
import org.mapstruct.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public interface InvoiceMapper {

    InvoiceEntity toInvoiceEntity (Invoice invoice);
}
