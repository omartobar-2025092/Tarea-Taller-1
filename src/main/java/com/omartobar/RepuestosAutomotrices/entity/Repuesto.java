package com.omartobar.RepuestosAutomotrices.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Repuestos")

public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRepuesto")
    private Integer idRepuesto;

    @Column(name = "nombreRepuesto", nullable = false, length = 100)
    private String nombreRepuesto;

    @Column(name = "descripcionRepuesto", nullable = false, columnDefinition = "TEXT")
    private String descripcionRepuesto;

    @Column(name = "precioRepuesto", nullable = false, precision = 8, scale = 2)
    private BigDecimal precioRepuesto;

    @Column(name = "stockRepuesto", nullable = false)
    private Integer stockRepuesto;

    // Getters y Setters //

    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getDescripcionRepuesto() {
        return descripcionRepuesto;
    }

    public void setDescripcionRepuesto(String descripcionRepuesto) {
        this.descripcionRepuesto = descripcionRepuesto;
    }

    public BigDecimal getPrecioRepuesto() {
        return precioRepuesto;
    }

    public void setPrecioRepuesto(BigDecimal precioRepuesto) {
        this.precioRepuesto = precioRepuesto;
    }

    public Integer getStockRepuesto() {
        return stockRepuesto;
    }

    public void setStockRepuesto(Integer stockRepuesto) {
        this.stockRepuesto = stockRepuesto;
    }
}


