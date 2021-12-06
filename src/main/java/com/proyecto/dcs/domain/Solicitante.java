package com.proyecto.dcs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Solicitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private String nombre;

    private String correo;

    private String autoBuscado;

    private double dineroEntregado;

    private String estadoSolicitud;

    public  Solicitante(){

    }

    public Solicitante(String nombre, String correo, String autoBuscado, double dineroEntregado, String estadoSolicitud) {
        this.nombre = nombre;
        this.correo = correo;
        this.autoBuscado = autoBuscado;
        this.dineroEntregado = dineroEntregado;
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAutoBuscado() {
        return autoBuscado;
    }

    public void setAutoBuscado(String autoBuscado) {
        this.autoBuscado = autoBuscado;
    }

    public double getDineroEntregado() {
        return dineroEntregado;
    }

    public void setDineroEntregado(double dineroEntregado) {
        this.dineroEntregado = dineroEntregado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }
}
