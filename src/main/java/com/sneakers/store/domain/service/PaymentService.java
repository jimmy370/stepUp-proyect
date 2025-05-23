package com.sneakers.store.domain.service;

import com.stripe.exception.StripeException;

import java.util.Map;

public interface PaymentService {

    Map<String, String> paySneakers(Map<String, Object> paymentData) throws StripeException;
}
