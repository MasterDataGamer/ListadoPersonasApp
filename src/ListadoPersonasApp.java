import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Object system;
        Scanner input = new Scanner(System.in);
        // Se define la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        // Menu
        boolean salir = false;
        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(input , personas);
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }
    private static void mostrarMenu(){
        //Se muestran las opciones
        System.out.println("""
                **** Listado de personas ****
                1. Agregar 
                2. Listar
                3. Salir
                """);
        System.out.print("Por favor seleccione la opcion: ");



    }
    private static boolean ejecutarOperacion(Scanner input , List<Persona> personas){
        var opcion = Integer.parseInt(input.nextLine());
        boolean salir = false;
        // Se verifica la opcion proporcionada
        switch (opcion){
            case 1: // Se agrega personas a la lista
                System.out.print("Por favor ingrese el nombre: ");
                var nombre = input.nextLine();
                System.out.print("Por favor ingrese el telefono: ");
                var tel = input.nextLine();
                System.out.print("Por favor ingrese el email: ");
                var email = input.nextLine();
                //Creando el objeto persona
                var persona = new Persona(nombre , tel , email);
                //Se agrega a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
                break;
            case 2: // Listar personas
                System.out.println("Listado de Personas");
                //Mejora usando lambda y metodo de referencia
                personas.forEach(System.out::println);
                break;

            case 3: // Salir del ciclo
                System.out.println("Adios...");
                salir = true;
                break;
            default:
                System.out.println("Opcion incorrecta: " + opcion);
        }// Fin switch
        return salir;

    }
}
