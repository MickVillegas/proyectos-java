package com.practica.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        int codigo = 227;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Long numEquipos = em.createQuery("SELECT COUNT(e) FROM Equipos e", Long.class).getSingleResult();

        List<Object[]> equipos = em.createQuery("SELECT eq.nombre, j.codigo, j.nombre, AVG(es.puntosPorPartido) FROM Equipos eq JOIN Jugadores j ON eq.nombre = j.nombreEquipo LEFT JOIN Estadisticas es ON j.codigo = es.jugador GROUP BY eq.nombre, j.codigo, j.nombre  ORDER BY eq.nombre", Object[].class).getResultList();


        System.out.println("Número de Equipos: " + numEquipos);
        System.out.println("==================================================");
        String equipoActual = "";

        boolean vueltaUno = true;
        for (Object[] fila : equipos) {
            String equipo = (String) fila[0];

            if (!equipo.equals(equipoActual)) {
                equipoActual = equipo;
                if(vueltaUno == false) {
                    System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .");
                    System.out.println("==================================================");
                }
                System.out.println("Equipo: " + equipo);
            }

            System.out.println(fila[1] + ", " + fila[2] + ", " + fila[3]);
            vueltaUno = false;
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("==================================================");

    }
}