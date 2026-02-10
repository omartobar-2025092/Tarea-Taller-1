package com.omartobar.RepuestosAutomotrices.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idProveedor")
    private Integer idProovedor;

    @Column (name = "nombreProveedor")
    private String nombreProveedor;

    @Column (name = "telefonoProveedor")
    private String telefonoProveedor;

    @Column (name = "direccionProveedor")
    private String direccionProveedor;

    @Column (name = "emailProveedor")
    private String emailProveedor;


    //Getters y Setters//


    public Integer getIdProovedor() {return idProovedor;}

    public void setIdProovedor(Integer idProovedor) {this.idProovedor = idProovedor;}

    public String getNombreProveedor() {return nombreProveedor;}

    public void setNombreProveedor(String nombreProveedor) {this.nombreProveedor = nombreProveedor;}

    public String getTelefonoProveedor() {return telefonoProveedor;}

    public void setTelefonoProveedor(String telefonoProveedor) {this.telefonoProveedor = telefonoProveedor;}

    public String getDireccionProveedor() {return direccionProveedor;}

    public void setDireccionProveedor(String direccionProveedor) {this.direccionProveedor = direccionProveedor;}

    public String getEmailProveedor() {return emailProveedor;}

    public void setEmailProveedor(String emailProveedor) {this.emailProveedor = emailProveedor;}
}
