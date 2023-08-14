package com.example.Model;

import lombok.Data;

@Data
public class Estudiante {

    private String nombre;
    private int edad;
    private String carrera;
    private Float promedio;

    public Estudiante() {}

    public Estudiante(String nombre, int edad, String carrera, Float promedio)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
    }

}
