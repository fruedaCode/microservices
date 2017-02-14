package com.fruedacode.microservices.zuulserver;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author ciberado
 */
public class FichaProducto {
    
    private String referencia;
    private String modelo;
    private String sexo;
    private String color;
    private String imagen;
    private BigDecimal precio;

    public FichaProducto(String referencia, String modelo, String sexo, String color, String imagen, BigDecimal precio) {
        this.referencia = referencia;
        this.modelo = modelo;
        this.sexo = sexo;
        this.color = color;
        this.imagen = imagen;
        this.precio = precio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.referencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FichaProducto other = (FichaProducto) obj;
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        return true;
    }

    
    
}
