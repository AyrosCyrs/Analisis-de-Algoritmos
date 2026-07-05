import java.io.*;
import java.util.ArrayList;

/**
 * Clase encargada de leer el archivo de texto con los datos
 * de las personas y convertirlos en objetos Persona.
 *
 * Formato esperado por línea:
 * nombre,edad,leGustanVaquitas
 *
 * @author Claudia Yarinet Osorio Lopez
 */
public class LectorArchivo {

    /**
     * Lee el archivo y regresa un arreglo de personas.
     */
    public static Persona[] leer(String nombreArchivo) throws IOException {
        ArrayList<Persona> personas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String nombre = datos[0];
            int edad = Integer.parseInt(datos[1]);
            boolean gusta = datos[2].equals("1");

            personas.add(new Persona(nombre, edad, gusta));
        }

        br.close();
        return personas.toArray(new Persona[0]);
    }
}
