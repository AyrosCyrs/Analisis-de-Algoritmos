import java.util.Scanner;

/**
 * Clase principal del programa.
 * Muestra el menú y ejecuta el problema seleccionado.
 *
 * @author Claudia Yarinet Osorio Lopez
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Resolver Problema 1");
        System.out.println("2. Resolver Problema 2");
        System.out.print("Selecciona una opción: ");

        int opcion = sc.nextInt();

        try {
            if (opcion == 1) {
                // Problema 1: repartir vaquitas
                Persona[] personas = LectorArchivo.leer("archivo.txt");
                BolsaVaquitas bolsa = new BolsaVaquitas(10);
                Problema1.resolver(personas, bolsa);

            } else if (opcion == 2) {
                // Problema 2: mostrar nombres y edades
                Persona[] personas = LectorArchivo.leer("archivo.txt");
                for (Persona p : personas) {
                    System.out.println(p.getNombre() + " " + p.getEdad());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar el programa.");
            e.printStackTrace();
        }

        sc.close();
    }
}
