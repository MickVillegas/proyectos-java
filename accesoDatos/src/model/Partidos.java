package com.practica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "partidos")
public class Partidos {

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "equipo_local", length = 20)
    private String equipoLocal;

    @Column(name = "equipo_visitante", length = 20)
    private String equipoVisitante;

    @Column(name = "puntos_local")
    private int puntosLocal;

    @Column(name = "puntos_visitante")
    private int puntosVisitante;

    @Column(name = "temporada", length = 5)
    private String temporada;

    public Partidos() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int x) {
        this.codigo = x;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String x) {
        this.equipoLocal = x;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String x) {
        this.equipoVisitante = x;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int x) {
        this.puntosLocal = x;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int x) {
        this.puntosVisitante = x;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String x) {
        this.temporada = x;
    }
}