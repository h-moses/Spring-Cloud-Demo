package com.ms.cloud_alibaba.service;

import com.ms.cloud_demo.entities.CommonResult;
import com.ms.cloud_demo.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = FallbackService.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id);
}
