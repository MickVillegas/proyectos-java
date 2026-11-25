package com.practica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_empleado")
    private int numEmpleado;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "oficio")
    private String oficio;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "salario")
    private double salario;

    public Empleados(){

    }

    public int getNumEmpleado(){
        return this.numEmpleado;
    }

    public void setNumEmpleado(int x){
        this.numEmpleado = x;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String x){
        this.apellido = x;
    }

    public String getOficio(){
        return this.oficio;
    }

    public void setOficio(String x){
        this.oficio = x;
    }

    public String getDepartamento(){
        return this.departamento;
    }

    public void getDepartamento(String x){
        this.departamento = x;
    }

    public double getsSlario(){
        return this.salario;
    }

    public void setsSlario(double x){
        this.salario = x;
    }

}
