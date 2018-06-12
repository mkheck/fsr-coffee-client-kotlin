package com.thehecklers.coffeeclient

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import javax.annotation.PostConstruct

@Component
class Demo(private val client: WebClient) {
    @PostConstruct
    private fun run() {
        client.get()
                .retrieve()
                .bodyToFlux<Coffee>()
                .filter { it.name.equals("tim hortons", ignoreCase = true) }
                .flatMap {
                    client.get()
                            .uri("/{id}/orders", it.id)
                            .retrieve()
                            .bodyToFlux<CoffeeOrder>()
                }
                .subscribe { println(it) }
    }
}