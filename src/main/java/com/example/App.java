package com.example;

import java.util.Scanner;

import com.example.Logica.EstudianteDAO;
import com.example.Model.Estudiante;

public class App 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do
        {
            System.out.println("BIENVENIDO!!");
            System.out.println("1. Agregar estudiante.");
            System.out.println("2. Eliminar estudiante.");
            System.out.println("3. Modificar estudiante.");
            System.out.println("4. Leer estudiantes");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch(opcion)
            {
                case 1 :
                {
                    Estudiante estudiante = new Estudiante();
                    EstudianteDAO dao = new EstudianteDAO();
                    System.out.println("Ingrese nombre del estudiante a agregar: ");
                    estudiante.setNombre(sc.next());
                    System.out.println("Ingrese la edad del estudiante: ");
                    estudiante.setEdad(sc.nextInt());
                    System.out.println("Ingrese la carrera del estudiante: ");
                    estudiante.setCarrera(sc.next());
                    
                    boolean agregado = dao.agregarEstudiante(estudiante);

                    if (agregado)
                        System.out.println("Se agrego correctamente el estudiante en la base de datos!");
                    else
                        System.out.println("No se pudo agregar el estudiante!");

                    break;
                }
                case 2:
                {
                    Estudiante estudiante = new Estudiante();
                    EstudianteDAO dao = new EstudianteDAO();
                    System.out.println("Ingrese nombre del estudiante a eliminar: ");
                    estudiante.setNombre(sc.next());
                    System.out.println("Ingrese la edad del estudiante: ");
                    estudiante.setEdad(sc.nextInt());
                    System.out.println("Ingrese la carrera del estudiante: ");
                    estudiante.setCarrera(sc.next());

                    boolean eliminado = dao.eliminarEstudiante(estudiante);

                    if (eliminado)
                        System.out.println("Se elimino correctamente el estudiante en la base de datos!");
                    else
                        System.out.println("No se pudo eliminar el estudiante!");

                    break;
                }
                case 3:
                {   
                    Estudiante estudiante = new Estudiante();
                    EstudianteDAO dao = new EstudianteDAO();
                    System.out.println("Ingrese datos del estudiante que quiere modificar: ");
                    System.out.println("Nombre del estudiante: ");
                    estudiante.setNombre(sc.next());
                    System.out.println("Edad del estudiante: ");
                    estudiante.setEdad(sc.nextInt());
                    System.out.println("Carrera del estudiante: ");
                    estudiante.setCarrera(sc.next());

                    Estudiante estudiante_actualizado = new Estudiante();
                    System.out.println("Ingrese los nuevos datos del estudiante: ");
                    System.out.println("Nombre del estudiante: ");
                    estudiante_actualizado.setNombre(sc.next());
                    System.out.println("Edad del estudiante: ");
                    estudiante_actualizado.setEdad(sc.nextInt());
                    System.out.println("Carrera del estudiante: ");
                    estudiante_actualizado.setCarrera(sc.next());
                    
                    boolean actualizado = dao.modificarEstudiante(estudiante, estudiante_actualizado);

                    if (actualizado)
                        System.out.println("Se actualizo el estudiante en la base de datos!");
                    else
                        System.out.println("No se pudo modificar el estudiante!");

                    break;
                }
                case 4:
                {
                    EstudianteDAO dao = new EstudianteDAO();
                    dao.leerEstudiantes();
                    break;
                }
            }

        } while (opcion != 5);
        sc.close();

    }
    
}
