package com.czinwen.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ytjia
 * @Create: 2020-06-02 21:53
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouterLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_baidu",r ->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
