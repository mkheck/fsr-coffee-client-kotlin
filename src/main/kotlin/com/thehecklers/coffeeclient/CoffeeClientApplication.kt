package com.thehecklers.coffeeclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
class CoffeeClientApplication {
    @Bean
    internal fun client(): WebClient {
        return WebClient.create("http://localhost:8080/coffees")
    }
}

fun main(args: Array<String>) {
    runApplication<CoffeeClientApplication>(*args)
}
