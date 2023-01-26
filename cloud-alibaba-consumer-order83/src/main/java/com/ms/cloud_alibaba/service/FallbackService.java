package com.ms.cloud_alibaba.service;

import com.ms.cloud_demo.entities.CommonResult;
import com.ms.cloud_demo.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class FallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> payment(Long id) {
        return new CommonResult<>(444, "服务降级返回");
    }
}
