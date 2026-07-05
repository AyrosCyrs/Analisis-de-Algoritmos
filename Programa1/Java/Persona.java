/**
 * Clase que modela a una persona.
 * Se usa tanto para el Problema 1 como para el Problema 2.
 *
 * @author Claudia Yarinet Osorio Lopez
 */
public class Persona {

    private String nombre;
    private int edad;
    private boolean leGustanVaquitas;

    /**
     * Constructor usado en el Problema 1.
     * Solo importa el nombre y si le gustan las vaquitas.
     */
    public Persona(String nombre, boolean leGustanVaquitas) {
        this.nombre = nombre;
        this.leGustanVaquitas = leGustanVaquitas;
    }

    /**
     * Constructor usado en el Problema 2.
     * Solo se consideran nombre y edad.
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Constructor completo.
     * Se usa al leer los datos desde el archivo.
     */
    public Persona(String nombre, int edad, boolean leGustanVaquitas) {
        this.nombre = nombre;
        this.edad = edad;
        this.leGustanVaquitas = leGustanVaquitas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean leGustanVaquitas() {
        return leGustanVaquitas;
    }
}
