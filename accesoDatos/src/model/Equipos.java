package com.practica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipos {

    @Id
    @Column(name = "Nombre", length = 20)
    private String nombre;

    @Column(name = "Ciudad", length = 20)
    private String ciudad;

    @Column(name = "Conferencia", length = 4)
    private String conferencia;

    @Column(name = "Division", length = 9)
    private String division;

    public Equipos() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String x) {
        this.nombre = x;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String x) {
        this.ciudad = x;
    }

    public String getConferencia() {
        return this.conferencia;
    }

    public void setConferencia(String x) {
        this.conferencia = x;
    }

    public String getDivision() {
        return this.division;
    }

    public void setDivision(String x) {
        this.division = x;
    }
}