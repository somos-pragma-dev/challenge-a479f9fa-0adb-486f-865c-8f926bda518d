package com.pragma.corepagos.infrastructure.adapters.external;

import com.pragma.corepagos.domain.model.Payment;
import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayAdapter {

    public PaymentGatewayAdapter() {
        // Constructor logic
    }

    @CircuitBreaker(name = "paymentGateway", fallbackMethod = "fallbackProcessPayment")
    @Retry(name = "paymentGateway")
    @Bulkhead(name = "paymentGateway")
    public void processPayment(Payment payment) {
        if (payment == null) {
            throw new InvalidPaymentException("Payment cannot be null");
        }

        // Simulate external service call
        if ("error".equals(payment.getPaymentId())) {
            throw new InvalidPaymentException("Payment processing failed");
        }
    }

    public void fallbackProcessPayment(Payment payment, Throwable t) {
        // Log the error and handle fallback logic
        System.err.println("Payment gateway processing failed: " + t.getMessage());
    }
}