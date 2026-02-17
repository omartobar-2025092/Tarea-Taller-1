package com.omartobar.RepuestosAutomotrices.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Categorias")

public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Integer idCategoria;

    @Column(name = "nombreCategoria", nullable = false, length = 100)
    private String nombreCategoria;

    @Column(name = "descripcionCategoria", nullable = false, columnDefinition = "TEXT")
    private String descripcionCategoria;


    // Getters y Setters //

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
}

