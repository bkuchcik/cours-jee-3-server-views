package fr.isima.cours.jee.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


/**
 * To enable intellij compatibility I had to implement a main in java not in Kotlin
 *
 */
@SpringBootApplication
@ComponentScan("fr.isima")
public class Server {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Server.class)
                .run(args);
    }
}