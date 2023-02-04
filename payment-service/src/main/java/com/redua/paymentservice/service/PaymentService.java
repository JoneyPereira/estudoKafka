package com.redua.paymentservice.service;

import com.redua.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
