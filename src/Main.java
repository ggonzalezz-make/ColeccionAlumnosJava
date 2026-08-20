// Se importan las clases que vamos a utilizar para trabajar con el programa.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    // Se crea un Map para almacenar los alumnos.
    // El carnet será la llave y el objeto Alumno será el valor.
    static Map<String, Alumno> alumnos = new HashMap<>();


    // Se crea un objeto Scanner para poder ingresar información desde el teclado.
    static Scanner teclado = new Scanner(System.in);


    // Método principal donde comienza la ejecución del programa.
    public static void main(String[] args) {

        // Variable que almacenará la opción seleccionada por el usuario.
        int opcion;


        // El ciclo do-while permite mostrar el menú hasta que el usuario
        // seleccione la opción de salir.
        do {

            System.out.println("\n===== SISTEMA DE ALUMNOS UDB VIRTUAL =====");
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Mostrar todos los alumnos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");


            // Se obtiene la opción seleccionada por el usuario.
            opcion = teclado.nextInt();

            // Se limpia el salto de línea que queda pendiente en el Scanner.
            teclado.nextLine();


            // Se utiliza switch para ejecutar una acción dependiendo
            // de la opción seleccionada.
            switch(opcion) {


                // Opción para ingresar un nuevo alumno.
                case 1:
                    ingresarAlumno();
                    break;


                // Opción para buscar un alumno mediante su carnet.
                case 2:
                    buscarAlumno();
                    break;


                // Opción para eliminar un alumno mediante su carnet.
                case 3:
                    eliminarAlumno();
                    break;


                // Opción para mostrar todos los alumnos registrados.
                case 4:
                    mostrarAlumnos();
                    break;


                // Opción para finalizar el programa.
                case 5:
                    System.out.println("Programa finalizado.");
                    break;


                // Se ejecuta cuando el usuario ingresa una opción
                // que no existe en el menú.
                default:
                    System.out.println("Opción no válida.");
            }


        // El menú continuará apareciendo mientras la opción no sea 5.
        } while(opcion != 5);


    }


    // Método encargado de ingresar un nuevo alumno al sistema.
    public static void ingresarAlumno() {


        // Se solicita el carnet del alumno.
        System.out.print("Ingrese carnet del alumno: ");
        String carnet = teclado.nextLine();


        // Se solicita el nombre completo del alumno.
        System.out.print("Ingrese nombre completo: ");
        String nombre = teclado.nextLine();


        // Se verifica si ya existe un alumno con ese carnet.
        if(alumnos.containsKey(carnet)) {

            System.out.println("El alumno ya existe.");

        } else {


            // Se crea un nuevo objeto de tipo Alumno
            // utilizando el carnet y nombre ingresados.
            Alumno alumno = new Alumno(carnet, nombre);


            // Se almacena el alumno dentro del Map.
            // El carnet funciona como llave y el alumno como valor.
            alumnos.put(carnet, alumno);


            // Se muestra el mensaje solicitado por el ejercicio.
            System.out.println("Alumno ingresado exitosamente");

        }


    }


    // Método encargado de buscar un alumno utilizando su carnet.
    public static void buscarAlumno() {


        // Se solicita el carnet que se desea buscar.
        System.out.print("Ingrese carnet a buscar: ");

        String carnet = teclado.nextLine();


        // Se utiliza el carnet para buscar el alumno dentro del Map.
        Alumno alumno = alumnos.get(carnet);


        // Se verifica si se encontró un alumno.
        if(alumno != null) {


            System.out.println("\nAlumno encontrado:");

            // Se muestra la información del alumno.
            System.out.println(alumno);


        } else {


            // Mensaje que se muestra cuando el carnet no existe.
            System.out.println(
                "Alumno no encontrado, no se puede Mostrar"
            );

        }


    }


    // Método encargado de eliminar un alumno mediante su carnet.
    public static void eliminarAlumno() {


        // Se solicita el carnet del alumno que se desea eliminar.
        System.out.print("Ingrese carnet del alumno a eliminar: ");

        String carnet = teclado.nextLine();


        // Se verifica si el carnet existe dentro del Map.
        if(alumnos.containsKey(carnet)) {


            // Se elimina el alumno utilizando el carnet como llave.
            alumnos.remove(carnet);


            // Se informa que la eliminación fue exitosa.
            System.out.println(
                "Alumno eliminado exitosamente"
            );


        } else {


            // Mensaje que se muestra cuando el carnet no fue encontrado.
            System.out.println(
                "Alumno no encontrado, No se puede Eliminar"
            );


        }


    }


    // Método encargado de mostrar todos los alumnos registrados.
    public static void mostrarAlumnos() {


        // Se verifica si el Map se encuentra vacío.
        if(alumnos.isEmpty()) {


            // Mensaje que se muestra cuando no existen alumnos registrados.
            System.out.println("No existen alumnos registrados.");


        } else {


            System.out.println("\n===== LISTADO DE ALUMNOS =====");


            // Se recorre la colección de alumnos utilizando un ciclo for.
            // values() permite obtener todos los objetos Alumno almacenados.
            for(Alumno alumno : alumnos.values()) {


                // Se muestra la información de cada alumno.
                System.out.println(alumno);


            }


        }


    }


}