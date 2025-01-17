package com.ciel.web.reactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class ReactiveApplication

fun main(args: Array<String>) {
		val ctx: ConfigurableApplicationContext =	runApplication<ReactiveApplication>(*args)
		val greetingClient: GreetingClient = ctx.getBean(GreetingClient::class.java)
		print(">> message = " + greetingClient.getMessage().block())
}
