package com.pragma.corepagos.infrastructure.controller;

import com.pragma.corepagos.application.usecase.ProcessPaymentUseCase;
import com.pragma.corepagos.domain.model.Payment;
import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private ProcessPaymentUseCase processPaymentUseCase;

    @PostMapping
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        try {
            Payment processedPayment = processPaymentUseCase.process(payment);
            return new ResponseEntity<>(processedPayment, HttpStatus.CREATED);
        } catch (InvalidPaymentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}