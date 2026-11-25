package com.practica.model;
import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "Nombre", length = 30)
    private String nombre;

    @Column(name = "Procedencia", length = 20)
    private String procedencia;

    @Column(name = "Altura", length = 4)
    private String altura;

    @Column(name = "Peso")
    private int peso;

    @Column(name = "Posicion", length = 12)
    private String posicion;

    @Column(name = "Nombre_equipo", length = 20)
    private String nombreEquipo;

    public Jugadores() {
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int x){
        this.codigo = x;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String x){
        this.nombre = x;
    }

    public String getProcedencia(){
        return this.procedencia;
    }

    public void setProcedencia(String x){
        this.procedencia = x;
    }

    public String getAltura(){
        return this.altura;
    }

    public void setAltura(String x){
        this.altura = x;
    }

    public int getPeso(){
        return this.peso;
    }

    public void getPeso(int x){
        this.peso = x;
    }

    public String getPosicion(){
        return this.posicion;
    }

    public void getPosicion(String x){
        this.posicion = x;
    }

    public String getNombre_equipo(){
        return this.nombreEquipo;
    }

    public void setNombre_equipo(String x){
        this.nombreEquipo = x;
    }

}
