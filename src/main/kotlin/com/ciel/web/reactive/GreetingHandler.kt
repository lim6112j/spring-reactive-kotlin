package com.ciel.web.reactive

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.BodyInserters
import reactor.core.publisher.Mono

@Component
class GreetingHandler {
		fun hello( request: ServerRequest): Mono<ServerResponse> {
				return ServerResponse.ok().body(BodyInserters.fromValue(Greeting("Hello, Spring!")))
		}
}
