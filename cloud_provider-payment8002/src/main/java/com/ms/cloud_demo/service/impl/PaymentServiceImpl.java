package com.ms.cloud_demo.service.impl;

import com.ms.cloud_demo.entities.Payment;
import com.ms.cloud_demo.dao.PaymentDao;
import org.springframework.stereotype.Service;
import com.ms.cloud_demo.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
