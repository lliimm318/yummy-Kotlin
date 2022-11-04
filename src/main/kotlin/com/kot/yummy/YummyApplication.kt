package com.kot.yummy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class YummyApplication

fun main(args: Array<String>) {
	runApplication<YummyApplication>(*args)
}
