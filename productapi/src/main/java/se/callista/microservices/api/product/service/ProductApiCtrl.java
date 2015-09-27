package se.callista.microservices.api.product.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductApiCtrl {
	
    private final ProductosServ service;

    @Autowired
    public ProductApiCtrl(ProductosServ service) {
        this.service = service;
    }

    
    @RequestMapping(value="/productosAuth", method=RequestMethod.GET)
    public List<Producto> obtenerProductos(@RequestHeader(value="Authorization") String authorizationHeader,
            Principal currentUser){
    	return service.obtenerProductos();
    }
    
    @RequestMapping(value="/productos", method=RequestMethod.GET)
    public List<Producto> obtenerProductos2(){
    	return service.obtenerProductos();
    }

}
