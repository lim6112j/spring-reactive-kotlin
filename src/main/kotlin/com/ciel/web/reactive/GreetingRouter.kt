package com.ciel.web.reactive

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.http.MediaType.APPLICATION_JSON
@Configuration(proxyBeanMethods = false)
class GreeingRouter {
		@Bean
		fun route( handler: GreetingHandler): RouterFunction<ServerResponse>
		{
				return RouterFunctions.route(GET("/hello").and(accept(APPLICATION_JSON)), handler::hello)
		}
}
