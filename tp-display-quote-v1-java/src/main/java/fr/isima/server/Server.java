package fr.isima.cours.jee.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("fr.isima")
public class Server {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Server.class)
                .run(args);
    }
}