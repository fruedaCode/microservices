package com.fruedacode.microservices.turbine;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;;

@SpringBootApplication
@EnableTurbine
@EnableAutoConfiguration
public class TurbineServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineServer.class).run(args);
    }

}

