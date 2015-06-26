/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javiermoreno.springcloud;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
   

    @Async
    public Future<Integer> obtenerStockAsync(String referencia) throws IOException {
        // Atiende qué bonito: indicas el nombre del servicio y restTemplate es capaz de recuperar su @
        String stockURL = "http://stockservice/productos/" + referencia + "/stock";
        String stockResponseBody = restTemplate.getForObject(stockURL, String.class);
        JsonNode stockJson = objectMapper.readTree(stockResponseBody);
        int unidadesDisponibles = stockJson.get("unidadesDisponibles").asInt();
        return new AsyncResult<>(unidadesDisponibles);
    }


    @Async
    public Future<Producto> obtenerFichaCatalogoAsync(String referencia) {
        String catalogoURL = "http://catalogoservice/catalogo/referencias/" + referencia;
        Producto producto = restTemplate.getForObject(catalogoURL, Producto.class);
        return new AsyncResult<>(producto);
    }
    
}
