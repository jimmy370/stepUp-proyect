package com.sneakers.store.domain.port;

import com.sneakers.store.domain.model.DetailsOrder;

public interface OrderDetailsPort {
    void saveOrderDetails(DetailsOrder detailsOrder);
}
