package fr.isima.server

import fr.isima.business.allQuotes
import fr.isima.business.toIndexedQuotes
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

@EnableAutoConfiguration
@ComponentScan("fr.isima")
@EnableWebMvc
class Application {

    @Bean
    fun quotes() = allQuotes.toIndexedQuotes()
}
