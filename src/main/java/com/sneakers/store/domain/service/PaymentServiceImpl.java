package com.sneakers.store.domain.service;

import com.sneakers.store.domain.port.PaymentPort;
import com.stripe.exception.StripeException;

import java.util.Map;

public class PaymentServiceImpl implements PaymentService{

    private PaymentPort paymentPort;

    public PaymentServiceImpl(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    @Override
    public Map<String, String> paySneakers(Map<String, Object> paymentData) throws StripeException {
        return paymentPort.paySneakers(paymentData);
    }
}
