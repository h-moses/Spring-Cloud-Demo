package com.ms.cloud_demo.service;

import com.ms.cloud_demo.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
