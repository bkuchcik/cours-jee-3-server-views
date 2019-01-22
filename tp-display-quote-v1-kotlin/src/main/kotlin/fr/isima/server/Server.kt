package fr.isima.server

import fr.isima.business.allQuotes
import fr.isima.business.toIndexedQuotes
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

@SpringBootApplication
@ComponentScan("fr.isima")
class Application {

    @Bean
    fun quotes() = allQuotes.toIndexedQuotes()
}
