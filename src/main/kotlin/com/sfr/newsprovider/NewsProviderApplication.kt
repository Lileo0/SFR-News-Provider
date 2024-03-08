package com.sfr.newsprovider

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NewsProviderApplication

fun main(args: Array<String>) {
    runApplication<NewsProviderApplication>(*args)
}
