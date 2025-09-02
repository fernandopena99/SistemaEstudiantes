package fer.presentacion;

import fer.datos.EstudianteDAO;
import fer.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        var estudianteDao = new EstudianteDAO();
        while(!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            } catch(Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }// fin while
    }

    private static void mostrarMenu(){
        System.out.print("""
            *** Estudiantes ***
            1. Listar estudiantes
            2. Buscar estudiantes
            3. Agregar estudiante
            4. Modificar estudiante
            5. Eliminar estudiante
            6. Salir
            Elige una opcion: 
            """);
    }

    private static boolean ejecutarOpciones(Scanner consola,
                                            EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> { //Listar estudiantes
                System.out.println("Listado de Estudiantes: ");
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> { // Buscar Estudiante
                System.out.println("Introduce el id del estudiante que buscas: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if (encontrado)
                    System.out.println("Estudiante encontrado " + estudiante);
                else
                    System.out.println("No se encontro al estudiante " + estudiante);
            }


            case 3 -> { // Agregar estudiante
                System.out.println("Agrega al estudiante:  ");
                System.out.print("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporciona el apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Proporciona el telefono: ");
                var tel = consola.nextLine();
                System.out.print("Proporciona el email: ");
                var email = consola.nextLine();
                // crear el objeto estudiante (sin el id)
                var estudiante= new Estudiante(nombre, apellido, tel, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if(agregado)
                    System.out.println("Estudiante agregado: " + estudiante);
                else
                    System.out.println("Estudiante NO agregado: " + estudiante);
            }
            case 4-> { // Modificar estudiantee
                System.out.println("Agrega al estudiante:  ");
                System.out.println("Proporciona el ID del estudiante:  ");
                var idEstudiante =  Integer.parseInt(consola.nextLine());
                System.out.print("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporciona el apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Proporciona el telefono: ");
                var tel = consola.nextLine();
                System.out.print("Proporciona el email: ");
                var email = consola.nextLine();

                var estudiante= new Estudiante( idEstudiante, nombre, apellido, tel, email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if(modificado)
                    System.out.println("Estudiante modificado: " + estudiante);
                else
                    System.out.println("Estudiante NO modificado: " + estudiante);
            }
            case 5 -> { //Eliminar estudiante
                System.out.println("Elimnar al estudiante:  ");
                System.out.println("Proporciona el ID del estudiante:  ");
                var idEstudiante =  Integer.parseInt(consola.nextLine());
                var estudiante= new Estudiante( idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if(eliminado)
                    System.out.println("Estudiante eliminado: " + estudiante);
                else
                    System.out.println("Estudiante NO eliminado: " + estudiante);
            }
            case 6 -> {
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida: " + opcion);
        }
        return salir;
    }
}
