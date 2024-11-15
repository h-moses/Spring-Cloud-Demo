package com.ms.cloud_demo.controller;

import com.ms.cloud_demo.entities.CommonResult;
import com.ms.cloud_demo.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.ms.cloud_demo.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody  Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果", result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，端口号：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询成功", paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询成功，端口号：" + serverPort, paymentById);
        } else {
            return new CommonResult(444, "没有对应记录");
        }
    }


    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
