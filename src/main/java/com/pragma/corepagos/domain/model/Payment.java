package com.pragma.corepagos.domain.model;

import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

public class Payment {

    @NotNull
    @Size(min = 1, max = 50)
    private String paymentId;

    @NotNull
    @Size(min = 1, max = 50)
    private String customerId;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private Instant timestamp;

    public Payment(String paymentId, String customerId, BigDecimal amount) {
        if (paymentId == null || paymentId.trim().isEmpty()) {
            throw new InvalidPaymentException("Payment ID cannot be null or empty");
        }
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new InvalidPaymentException("Customer ID cannot be null or empty");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPaymentException("Amount must be positive");
        }
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.timestamp = Instant.now();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + "'," +
                "customerId='" + customerId + "'," +
                "amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}