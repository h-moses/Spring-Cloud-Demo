package com.ms.cloud_demo;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> hystrixMetricsStreamServletServletRegistrationBean = new ServletRegistrationBean<>(streamServlet);
        hystrixMetricsStreamServletServletRegistrationBean.setLoadOnStartup(1);
        hystrixMetricsStreamServletServletRegistrationBean.addUrlMappings("/hystrix.stream");
        hystrixMetricsStreamServletServletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return hystrixMetricsStreamServletServletRegistrationBean;
    }

}
