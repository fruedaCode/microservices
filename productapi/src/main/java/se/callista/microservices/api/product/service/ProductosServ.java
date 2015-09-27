package se.callista.microservices.api.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;



/**
 *
 * @author ciberado
 */
@Service
@RefreshScope
public class ProductosServ {


    private final IntegracionWebservices integracion;

    @Autowired
    public ProductosServ(IntegracionWebservices integracion) {
        this.integracion = integracion;
    }

    public List<Producto> obtenerProductos() {
    	return integracion.obtenerProductos();
    }

}
