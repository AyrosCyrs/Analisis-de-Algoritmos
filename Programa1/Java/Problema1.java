/**
 * Solución del Problema 1.
 * Se reparten vaquitas solo a las personas a las que les gustan,
 * mientras haya disponibles.
 *
 * @author Claudia Yarinet Osorio Lopez
 */
public class Problema1 {

    /**
     * Recorre el arreglo de personas y entrega vaquitas.
     * Imprime los nombres de quienes sí alcanzaron.
     */
    public static void resolver(Persona[] personas, BolsaVaquitas bolsa) {
        System.out.println("Personas que recibieron vaquitas:");

        for (Persona p : personas) {
            if (p.leGustanVaquitas()) {
                if (bolsa.darVaquita()) {
                    System.out.println(p.getNombre());
                } else {
                    break;
                }
            }
        }
    }
}
