package com.sneakers.store.infraestructure.adapter;

import com.sneakers.store.domain.model.DetailsOrder;
import com.sneakers.store.domain.port.OrderDetailsPort;
import com.sneakers.store.infraestructure.mapper.OrderDetailsMapper;
import com.sneakers.store.infraestructure.repository.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderDetailsAdapter implements OrderDetailsPort {

    private OrderDetailsRepository orderDetailsRepository;

    private OrderDetailsMapper orderDetailsMapper;

    @Override
    public void saveOrderDetails(DetailsOrder detailsOrder) {
        orderDetailsRepository.save(orderDetailsMapper.toDetailsOrderEntity(detailsOrder));
    }
}
