/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fruedacode.microservices.fichaservice;

import java.io.IOException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;




/**
 *
 * @author ciberado
 */
@Component
public class IntegracionWebservices {
    
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public IntegracionWebservices(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }
   

//    @HystrixCommand
//    public Future<Integer> obtenerStockAsync(String referencia) throws IOException {
//        // Atiende qué bonito: indicas el nombre del servicio y restTemplate es capaz de recuperar su @
//        String stockURL = "http://stockservice/productos/" + referencia + "/stock";
//        String stockResponseBody = restTemplate.getForObject(stockURL, String.class);
//        JsonNode stockJson = objectMapper.readTree(stockResponseBody);
//        int unidadesDisponibles = stockJson.get("unidadesDisponibles").asInt();
//        return new AsyncResult<>(unidadesDisponibles);
//    }
    
    @HystrixCommand
    public Future<Integer> obtenerStockAsync(final String referencia) {
        return new AsyncResult<Integer>() {
            @Override
            public Integer invoke(){
              String stockURL = "http://stockservice/productos/" + referencia + "/stock";
              String stockResponseBody = restTemplate.getForObject(stockURL, String.class);
              JsonNode stockJson = null;
              Integer result = 0;
			try {
				stockJson = objectMapper.readTree(stockResponseBody);
				result = stockJson.get("unidadesDisponibles").asInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            	return result;
            }
        };
    }

    
    @HystrixCommand
    public Future<Producto> obtenerFichaCatalogoAsync(final String referencia) {
        return new AsyncResult<Producto>() {
            @Override
            public Producto invoke() {
                String catalogoURL = "http://catalogoservice/catalogo/referencias/" + referencia;
                Producto producto = restTemplate.getForObject(catalogoURL, Producto.class);
                return producto;
            }
        };
    }

//    @HystrixCommand
//    public Future<Producto> obtenerFichaCatalogoAsync(String referencia) {
//        String catalogoURL = "http://catalogoservice/catalogo/referencias/" + referencia;
//        Producto producto = restTemplate.getForObject(catalogoURL, Producto.class);
//        return new AsyncResult<>(producto);
//    }
    
//    public Future<Producto> defaultFicha(String referencia) {
//    	 return new AsyncResult<>(new Producto());
//    }
//    public Future<Integer> defaultStock(String referencia) {
//    	 return new AsyncResult<>(0);
//    }

}
