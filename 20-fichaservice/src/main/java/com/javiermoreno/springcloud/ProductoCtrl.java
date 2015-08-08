package com.javiermoreno.springcloud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ciberado
 */
@RestController
public class ProductoCtrl {

    private final ProductosServ service;

    @Autowired
    public ProductoCtrl(ProductosServ service) {
        this.service = service;
    }
    
    
    @RequestMapping(value="/productos", method=RequestMethod.GET)
    public List<Producto> obtenerProductos() 
    		throws IOException, InterruptedException, ExecutionException {
    	List<Producto> listaProductos = new ArrayList<Producto>();
    	listaProductos.add(service.obtenerProducto("12"));
    	listaProductos.add(service.obtenerProducto("15"));
        return listaProductos;
    }
    
    @RequestMapping(value="/productos/{referencia}", method=RequestMethod.GET)
    public Producto obtenerProductoParalelo(@PathVariable String referencia) 
    throws IOException, InterruptedException, ExecutionException {
        return service.obtenerProducto(referencia);
    }
    
    
}
