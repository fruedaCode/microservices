package com.fruedacode.microservices.zuulserver;

import java.util.Objects;

/**
 *
 * @author ciberado
 */
public class StockProducto {
    private String referencia;
    private int unidadesDisponibles;

    public StockProducto(String referencia, int unidadesDisponibles) {
        this.referencia = referencia;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }


    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.referencia);
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
        final StockProducto other = (StockProducto) obj;
        return Objects.equals(this.referencia, other.referencia);
    }

    
    
}
