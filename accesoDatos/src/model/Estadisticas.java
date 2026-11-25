package com.practica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estadisticas")
@IdClass(EstadisticasId.class)
public class Estadisticas {

    @Id
    @Column(name = "temporada", length = 5)
    private String temporada;

    @Id
    @Column(name = "jugador")
    private int jugador;

    @Column(name = "Puntos_por_partido")
    private double puntosPorPartido;

    @Column(name = "Asistencias_por_partido")
    private double asistenciasPorPartido;

    @Column(name = "Tapones_por_partido")
    private double taponesPorPartido;

    @Column(name = "Rebotes_por_partido")
    private double rebotesPorPartido;

    public Estadisticas() {
    }

    // Getters y Setters
    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String x) {
        this.temporada = x;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int x) {
        this.jugador = x;
    }

    public double getPuntosPorPartido() {
        return puntosPorPartido;
    }

    public void setPuntosPorPartido(double x) {
        this.puntosPorPartido = x;
    }

    public double getAsistenciasPorPartido() {
        return asistenciasPorPartido;
    }

    public void setAsistenciasPorPartido(double x) {
        this.asistenciasPorPartido = x;
    }

    public double getTaponesPorPartido() {
        return taponesPorPartido;
    }

    public void setTaponesPorPartido(double x) {
        this.taponesPorPartido = x;
    }

    public double getRebotesPorPartido() {
        return rebotesPorPartido;
    }

    public void setRebotesPorPartido(double x) {
        this.rebotesPorPartido = x;
    }
}
