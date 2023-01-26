package com.ms.cloud_alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ms.cloud_alibaba.service.PaymentService;
import com.ms.cloud_demo.entities.CommonResult;
import com.ms.cloud_demo.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;


    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback", fallback = "handleFallback")
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/payment/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("该ID没有对应记录");
        }

        return result;
    }

    public CommonResult handleFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "handleFallback \t" + e.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException exception) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(445, "blockHandler " + exception.getMessage(), payment);
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id) {
        return paymentService.payment(id);
    }
}
