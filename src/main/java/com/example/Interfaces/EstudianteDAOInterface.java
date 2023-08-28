package com.example.Interfaces;

import com.example.Model.Estudiante;

public interface EstudianteDAOInterface {

    boolean agregarEstudiante(Estudiante estudiante);

    boolean eliminarEstudiante(Estudiante estudiante);

    boolean modificarEstudiante(Estudiante estudiante, Estudiante estudiante_actualizado);

    void leerEstudiantes();

}