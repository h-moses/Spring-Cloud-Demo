package com.ms.cloud_alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ms.cloud_demo.entities.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(444, "全局，客户自定义----1");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(444, "全局，客户自定义----2");
    }
}
