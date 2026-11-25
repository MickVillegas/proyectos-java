package com.practica.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        int codigo = 227;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        List<Jugadores> resultadosJugadores = em.createQuery("SELECT j from Jugadores j WHERE j.codigo = :cod", Jugadores.class).setParameter("cod", codigo).getResultList();
        List<Estadisticas> resultados = em.createQuery("SELECT e from Estadisticas e WHERE e.jugador = :cod", Estadisticas.class).setParameter("cod", codigo).getResultList();

        if(resultadosJugadores.size() == 0 || resultados.size() == 0){
            System.out.println("El jugador no existe");
        }
        else{
        for (int i = 0; i < resultadosJugadores.size(); i++) {
            Jugadores jugadores = resultadosJugadores.get(i);
            System.out.println("DATOS DEL JUGADOR: " + jugadores.getCodigo());
            System.out.println("Nombre: " + jugadores.getNombre());
            System.out.println("Equipo: " + jugadores.getNombre_equipo());
        }

        System.out.println("======================================");
        System.out.println("Temporada   Ptos    Asis    Tap    Reb");

        for (int i = 0; i < resultados.size(); i++) {
            Estadisticas estadistica = resultados.get(i);
            System.out.println(estadistica.getTemporada() + "       " + estadistica.getPuntosPorPartido() + "     " + estadistica.getAsistenciasPorPartido() + "     " + estadistica.getTaponesPorPartido() + "   " + estadistica.getRebotesPorPartido());
        }
            System.out.println("======================================");
            System.out.println("Num de registros: " + resultados.size());
            System.out.println("======================================");
        }

    }
}