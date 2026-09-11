package com.pragma.corepagos.application.usecase;

import com.pragma.corepagos.domain.model.Payment;
import com.pragma.corepagos.infrastructure.adapters.external.AntifraudServiceAdapter;
import com.pragma.corepagos.infrastructure.adapters.external.PaymentGatewayAdapter;
import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Service;

@Service
public class ProcessPaymentUseCase {

    private final AntifraudServiceAdapter antifraudServiceAdapter;
    private final PaymentGatewayAdapter paymentGatewayAdapter;

    public ProcessPaymentUseCase(AntifraudServiceAdapter antifraudServiceAdapter, PaymentGatewayAdapter paymentGatewayAdapter) {
        this.antifraudServiceAdapter = antifraudServiceAdapter;
        this.paymentGatewayAdapter = paymentGatewayAdapter;
    }

    @CircuitBreaker(name = "payment", fallbackMethod = "fallbackProcessPayment")
    @Retry(name = "payment")
    @Bulkhead(name = "payment")
    public void processPayment(Payment payment) {
        if (payment == null) {
            throw new InvalidPaymentException("Payment cannot be null");
        }

        antifraudServiceAdapter.checkFraud(payment);
        paymentGatewayAdapter.processPayment(payment);
    }

    public void fallbackProcessPayment(Payment payment, Throwable t) {
        // Log the error and handle fallback logic
        System.err.println("Payment processing failed: " + t.getMessage());
    }
}