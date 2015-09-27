/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.callista.microservices.api.product.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;




/**
 *
 * @author ciberado
 */
@Component
public class IntegracionWebservices {
    
    private final RestTemplate restTemplate;

    @Autowired
    public IntegracionWebservices(@Qualifier("loadBalancedRestTemplate")RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand
    public List<Producto> obtenerProductos() {
        String productosURL = "http://productoscomposite/getProductosComposite";
        Producto[] productos = restTemplate.getForObject(productosURL, Producto[].class);
        return Arrays.asList(productos);

    }
}
