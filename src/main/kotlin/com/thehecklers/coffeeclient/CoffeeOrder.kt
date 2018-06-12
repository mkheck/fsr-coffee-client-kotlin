package com.thehecklers.coffeeclient

import java.time.Instant

data class CoffeeOrder(val coffeeId: String, val whenOrdered: Instant)