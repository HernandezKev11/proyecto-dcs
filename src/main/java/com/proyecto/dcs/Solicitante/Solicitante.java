package com.proyecto.dcs.Solicitante;

import java.time.LocalDateTime;

public class Solicitante {

    private Long id;

    private String nombre;

    private String correo;

    private String autoBuscado;

    private String dineroEntregado;

    private String estadoSolicitud;

    private LocalDateTime fechaSolicitud;

    public  Solicitante(){

    }

    public Solicitante(Long id, String nombre, String correo, String autoBuscado, String dineroEntregado, String estadoSolicitud, LocalDateTime fechaSolicitud) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.autoBuscado = autoBuscado;
        this.dineroEntregado = dineroEntregado;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
    }

    public Solicitante(String nombre, String correo, String autoBuscado, String dineroEntregado, String estadoSolicitud, LocalDateTime fechaSolicitud) {
        this.nombre = nombre;
        this.correo = correo;
        this.autoBuscado = autoBuscado;
        this.dineroEntregado = dineroEntregado;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
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

    public String getDineroEntregado() {
        return dineroEntregado;
    }

    public void setDineroEntregado(String dineroEntregado) {
        this.dineroEntregado = dineroEntregado;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
