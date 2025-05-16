package com.sneakers.store.domain.port;

import com.sneakers.store.domain.model.Invoice;

public interface InvoicePort {

    void saveInvoice(Invoice invoice);
}
