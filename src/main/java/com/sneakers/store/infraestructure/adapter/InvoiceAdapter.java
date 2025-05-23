package com.sneakers.store.infraestructure.adapter;

import com.sneakers.store.domain.dto.InvoiceDto;
import com.sneakers.store.domain.model.Invoice;
import com.sneakers.store.domain.port.InvoicePort;
import com.sneakers.store.infraestructure.mapper.InvoiceMapper;
import com.sneakers.store.infraestructure.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceAdapter implements InvoicePort {

    private InvoiceRepository invoiceRepository;

    private InvoiceMapper invoiceMapper;

    public InvoiceAdapter(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoiceMapper.toInvoiceEntity(invoice));
    }
}
