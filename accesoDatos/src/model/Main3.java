package com.practica.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;
public class Main3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Estadisticas es = new Estadisticas();
        Estadisticas es2 = new Estadisticas();
        int jugador = 123;

        Long buscarJugador = em.createQuery("SELECT COUNT(j) FROM Jugadores j WHERE j.codigo = :cod", Long.class).setParameter("cod", jugador).getSingleResult();



        if(buscarJugador == 0){
            System.out.println("El jugador con código " + jugador + " no existe");
        }

        else{
            em.getTransaction().begin();

            es.setJugador(jugador);
            es.setTemporada("05/06");
            es.setPuntosPorPartido(7);
            es.setAsistenciasPorPartido(0);
            es.setTaponesPorPartido(0);
            es.setRebotesPorPartido(5);

            em.persist(es);

            em.getTransaction().commit();

            em.getTransaction().begin();

            es2.setJugador(jugador);
            es2.setTemporada("06/07");
            es2.setPuntosPorPartido(10);
            es2.setAsistenciasPorPartido(0);
            es2.setTaponesPorPartido(3);
            es2.setRebotesPorPartido(0);

            em.persist(es2);

            em.getTransaction().commit();

            System.out.println("Datos insertados con éxito");
        }
    }
}
