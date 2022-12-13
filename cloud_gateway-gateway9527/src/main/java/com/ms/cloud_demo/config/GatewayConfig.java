package com.ms.cloud_demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder locatorBuilder) {
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();

        routes.route("path_route_ms", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("path_route_ji", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
