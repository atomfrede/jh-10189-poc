package com.github.atomfrede.jh10189poc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GatewayApplication {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//@formatter:off
		return builder.routes()
				.route("shell-api", r -> r.path("/shell/*")
						.uri("http://localhost:8081"))
				.route("shell-assets", r -> r.path("/shell/static/*")
						.uri("http://localhost:8081/shell/static"))
				.route("default-layout", r -> r.path("/*")
						.uri("http://localhost:9000/index"))
				.build();
		//@formatter:on
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
