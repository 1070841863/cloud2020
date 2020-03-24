package com.pro.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author study
 * @create 2020-03-23 21:03
 */
@Configuration
public class GateWayConfig {

    /*
    配置一个id为path_route_test1路由规则，
    当访问地址http://localhost:9527/guonei的时候，会自动转发到地址：http://news.baidu.com/guonei
     */
    @Bean
    public RouteLocator customRoteLocator(RouteLocatorBuilder  routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_test1",
                r->r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();
        return routes.build()  ;
    }

    @Bean
    public RouteLocator customRoteLocator2(RouteLocatorBuilder  routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_test1",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        return routes.build()  ;
    }
}
