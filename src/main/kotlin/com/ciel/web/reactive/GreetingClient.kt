package com.ciel.web.reactive

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.http.MediaType
import reactor.core.publisher.Mono

@Component
class GreetingClient {
		private var client: WebClient
		constructor(builder: WebClient.Builder) {
				this.client = builder.baseUrl("http://localhost:8080").build()
		}
		fun getMessage(): Mono<String> {
				return this.client.get()
						.uri("/hello")
						.accept(MediaType.APPLICATION_JSON)
						.retrieve()
						.bodyToMono(Greeting::class.java)
						.map(Greeting::message)
		}
}
