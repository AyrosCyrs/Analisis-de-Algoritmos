/**
 * Solución del Problema 2.
 * A partir de arreglos de nombres y edades,
 * se crea un arreglo de objetos Persona.
 *
 * @author Claudia Yarinet Osorio Lopez
 */
public class Problema2 {

    /**
     * Construye un arreglo de personas usando dos arreglos paralelos.
     *
     * @return arreglo de objetos Persona
     */
    public static Persona[] resolver(String[] nombres, int[] edades) {
        Persona[] personas = new Persona[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            personas[i] = new Persona(nombres[i], edades[i]);
        }

        return personas;
    }
}
