package com.ciel.web.reactive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.BodyInserter
import org.springframework.web.reactive.function.BodyInserters

import org.springframework.http.MediaType
import kotlin.ByteArray
import kotlin.test.expect
import reactor.core.publisher.Mono
import org.springframework.test.web.reactive.server.WebTestClient
import org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReactiveApplicationTests {
		@Autowired lateinit private var webClient : WebTestClient
	@Test
	fun helloTest() {
			webClient
					.get()
					.uri("/hello")
					.accept(MediaType.APPLICATION_JSON)
					.exchange()
					.expectStatus().isOk()
					.expectBody(Greeting::class.java).value{ greeting:Greeting ->
							assertThat(greeting.message).isEqualTo("Hello, Spring!")
					}
	}

}
