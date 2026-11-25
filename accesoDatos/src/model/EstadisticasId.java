package com.practica.model;

import java.io.Serializable;
import java.util.Objects;

public class EstadisticasId implements Serializable {
    private String temporada;
    private int jugador;

    public EstadisticasId() {}

    public EstadisticasId(String temporada, int jugador) {
        this.temporada = temporada;
        this.jugador = jugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadisticasId that = (EstadisticasId) o;
        return jugador == that.jugador && Objects.equals(temporada, that.temporada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temporada, jugador);
    }
}