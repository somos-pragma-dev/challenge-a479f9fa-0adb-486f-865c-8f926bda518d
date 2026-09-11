package com.pragma.corepagos.infrastructure.adapters.external;

import com.pragma.corepagos.domain.model.Payment;
import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Component;

@Component
public class AntifraudServiceAdapter {

    public AntifraudServiceAdapter() {
        // Constructor logic
    }

    @CircuitBreaker(name = "antifraud", fallbackMethod = "fallbackCheckFraud")
    @Retry(name = "antifraud")
    @Bulkhead(name = "antifraud")
    public void checkFraud(Payment payment) {
        if (payment == null) {
            throw new InvalidPaymentException("Payment cannot be null");
        }

        // Simulate external service call
        if ("fraud".equals(payment.getCustomerId())) {
            throw new InvalidPaymentException("Potential fraud detected");
        }
    }

    public void fallbackCheckFraud(Payment payment, Throwable t) {
        // Log the error and handle fallback logic
        System.err.println("Antifraud check failed: " + t.getMessage());
    }
}