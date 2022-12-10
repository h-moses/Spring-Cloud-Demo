package com.ms.cloud_demo.service.impl;

import com.ms.cloud_demo.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallbackService paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "---------PaymentFallbackService paymentInfo_Timeout";
    }
}
