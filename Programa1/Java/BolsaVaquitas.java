/**
 * Clase que representa una bolsa con una cantidad limitada de vaquitas.
 *
 * @author Claudia Yarinet Osorio Lopez
 */
public class BolsaVaquitas {

    private int cantidad;

    /**
     * Inicializa la bolsa con cierta cantidad de vaquitas.
     */
    public BolsaVaquitas(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Intenta entregar una vaquita.
     *
     * @return true si aún había vaquitas, false si ya se acabaron.
     */
    public boolean darVaquita() {
        if (cantidad > 0) {
            cantidad--;
            return true;
        }
        return false;
    }
}
