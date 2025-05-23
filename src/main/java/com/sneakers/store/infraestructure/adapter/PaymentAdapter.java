package com.sneakers.store.infraestructure.adapter;

import com.sneakers.store.domain.port.PaymentPort;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class PaymentAdapter implements PaymentPort {
    @Override
    public Map<String, String> paySneakers(Map<String, Object> paymentData)  throws StripeException {
        Stripe.apiKey ="sk_test_51RReWT4J9OJ26E30OmDVcX7IiLhvMBj0bgRJcSSwxZXJqebE4rEaBUT3ufB8dxQAfiw7GagGBu4fcn5DWcMjpDKE007dXC1zPg";
        long amount = ((Number) paymentData.get("amount")).longValue();
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(amount)
                .setCurrency("usd")
                .build();

        PaymentIntent intent = PaymentIntent.create(params);

        Map<String, String> response = new HashMap<>();
        response.put("clientSecret", intent.getClientSecret());
        log.info("respuesta de pago: {}",response);
        return response;
    }
}
