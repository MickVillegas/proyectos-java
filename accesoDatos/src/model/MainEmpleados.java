package com.practica.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class MainEmpleados {

    public static void pintarTrabajador(EntityManager em, int num){
        List<Empleados> primerTrabajador = em.createQuery("SELECT e from Empleados e WHERE e.numEmpleado = :cod", Empleados.class).setParameter("cod", num).getResultList();
        Empleados emp = primerTrabajador.get(0);

        System.out.println("Nº de empleado: " + emp.getNumEmpleado());
        System.out.println("Apellidos: " + emp.getApellido());
        System.out.println("Oficio: " + emp.getOficio());
        System.out.println("Departamento: " + emp.getDepartamento());
        System.out.println("Salario: " + emp.getsSlario());
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        int pagina = 1;
        boolean salir = false;
        Empleados emple = new Empleados();
        Scanner sc = new Scanner(System.in);

        long cargarNumeroEmpleados = em.createQuery("SELECT COUNT(e) FROM Empleados e", Long.class).getSingleResult();

        System.out.println("Ejecutando consulta");

        if(cargarNumeroEmpleados == 0){
            System.out.println("No hay empleados");
        }
        else{

            while(salir == false){

                System.out.println("Opciones a elegir:");
                System.out.println("------------------------");
                System.out.println("1 - Primer registro");
                System.out.println("2 - Siguiente");
                System.out.println("3 - Anterior");
                System.out.println("4 - último registro");
                System.out.println("5 - Salir del programa");

                int opcion = sc.nextInt();

                switch(opcion){

                    case 1:
                        System.out.println("Datos del primer empleado");
                        pintarTrabajador(em, 1);
                        break;

                    case 2:
                        if(pagina + 1 > (int)cargarNumeroEmpleados){
                            System.out.println("Estás en el último registro");
                        }
                        else{
                            pagina++;
                            System.out.println("Datos del siguiente empleado");
                            pintarTrabajador(em, pagina);
                        }
                        break;

                    case 3:

                        if(pagina == 1){
                            System.out.println("Estás en el primer registro");
                        }
                        else{
                            pagina--;
                            System.out.println("Datos del anterior empleado");
                            pintarTrabajador(em, pagina);
                        }
                        break;

                    case 4:
                        System.out.println("Datos del ultimo empleado");
                        pintarTrabajador(em, (int)cargarNumeroEmpleados);
                        break;

                    case 5:
                        salir = true;
                        break;
                }
            }
        }
    }
}
