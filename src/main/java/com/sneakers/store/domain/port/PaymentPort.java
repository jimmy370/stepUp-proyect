package com.sneakers.store.domain.port;

import com.stripe.exception.StripeException;

import java.util.Map;

public interface PaymentPort {

    Map<String, String> paySneakers(Map<String, Object> paymentData) throws StripeException;
}
