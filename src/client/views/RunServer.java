package client.views;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import server.controllers.HelloWorldController;

@SpringBootApplication
public class RunServer {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
    }

}