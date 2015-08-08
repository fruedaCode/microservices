package com.javiermoreno.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableDiscoveryClient
@Controller
public class StaticServer {

    
    public static void main(String[] args) {
        SpringApplication.run(StaticServer.class, args);
    }
}
