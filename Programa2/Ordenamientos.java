import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Clase que implementa distintos algoritmos de ordenamiento
 * @author Claudia Yarinet Osorio Lopez
 * @Github Clausyari
 * @Date 2026.01.20
 */
public class Ordenamientos {

    /**
     * Intercambia dos elementos de un arreglo.
     * @param arr El arreglo donde se realizará el intercambio.
     * @param i Índice del primer elemento.
     * @param j Índice del segundo elemento.
     */
    private static void intercambiar(int[] arr, int i, int j){
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    /**
     * Encuentra el índice del elemento menor en el rango [i, j].
     * @param arr El arreglo donde se buscará el elemento menor.
     * @param i Índice inicial del rango.
     * @param j Índice final del rango.
     * @return El índice del elemento menor.
     */
    private static int encontrarIndiceMenor(int[] arr, int i, int j){
        int indiceMenor = i;
        for (int k = i + 1; k <= j; k++) {
            if (arr[k] < arr[indiceMenor]) {
                indiceMenor = k;
            }
        }
        return indiceMenor;
    }

    /**
     * Ordena un arreglo usando Insertion Sort.
     * @param arr el arreglo a ordenar.
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int actual = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > actual) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = actual;
        }
    }

    /**
     * Ordena un arreglo usando Selection Sort.
     * @param arr el arreglo a ordenar.
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indiceMenor = encontrarIndiceMenor(arr, i, arr.length - 1);
            intercambiar(arr, i, indiceMenor);
        }
    }

    /**
     * Ordena un arreglo usando Bubble Sort.
     * @param arr el arreglo a ordenar.
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    intercambiar(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * Encuentra el valor máximo en un arreglo.
     * @param arr El arreglo donde se buscará el valor máximo.
     * @return El valor máximo encontrado.
     */
    private static int encontrarMaximo(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Ordena un arreglo usando Counting Sort.
     * @param arr el arreglo a ordenar.
     */
    public static void countingSort(int[] arr) {
        int max = encontrarMaximo(arr);
        int[] conteo = new int[max + 1];

        for (int num : arr) {
            conteo[num]++;
        }

        int index = 0;
        for (int i = 0; i < conteo.length; i++) {
            while (conteo[i] > 0) {
                arr[index++] = i;
                conteo[i]--;
            }
        }
    }

    /**
     * Ordena un arreglo usando Merge Sort.
     * @param arr el arreglo a ordenar.
     */
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mitad = arr.length / 2;
        int[] izq = Arrays.copyOfRange(arr, 0, mitad);
        int[] der = Arrays.copyOfRange(arr, mitad, arr.length);

        mergeSort(izq);
        mergeSort(der);
        mezclar(izq, der, arr);
    }

    /**
     * Mezcla dos arreglos ordenados.
     * @param izq El arreglo izquierdo.
     * @param der El arreglo derecho.
     * @param resultado El arreglo donde se almacenará el resultado mezclado.
     */
    private static void mezclar(int[] izq, int[] der, int[] resultado) {
        int i = 0, j = 0, k = 0;

        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) {
                resultado[k++] = izq[i++];
            } else {
                resultado[k++] = der[j++];
            }
        }

        while (i < izq.length) {
            resultado[k++] = izq[i++];
        }

        while (j < der.length) {
            resultado[k++] = der[j++];
        }
    }

    /**
     * Ordena un arreglo usando Quick Sort.
     * @param arr el arreglo a ordenar.
     */
    public static void quickSort(int[] arr){
        quickSortAux(arr, 0, arr.length - 1);
    }

    /**
     * Función auxiliar para Quick Sort.
     * @param arr el arreglo a ordenar.
     * @param inicio el índice inicial del subarreglo.
     * @param fin el índice final del subarreglo.
     */
    private static void quickSortAux(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particionar(arr, inicio, fin);
            quickSortAux(arr, inicio, pivote - 1);
            quickSortAux(arr, pivote + 1, fin);
        }
    }

    /**
     * Particiona el arreglo alrededor de un pivote.
     * @param arr el arreglo a ordenar.
     * @param inicio el índice inicial del subarreglo.
     * @param fin el índice final del subarreglo.
     * @return el índice del pivote después de la partición.
     */
    private static int particionar(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                intercambiar(arr, i, j);
            }
        }
        intercambiar(arr, i + 1, fin);
        return i + 1;
    }

    /**
     * Método principal para ejecutar el programa.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Tamaño del arreglo: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(arr));

        System.out.println("Elige el algoritmo:\n");
        System.out.println("    1.- Insertion Sort");
        System.out.println("    2.- Selection Sort");
        System.out.println("    3.- Bubble Sort");
        System.out.println("    4.- Counting Sort");
        System.out.println("    5.- Merge Sort");
        System.out.println("    6.- Quick Sort");

        System.out.print("\nRespuesta: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1: insertionSort(arr); break;
            case 2: selectionSort(arr); break;
            case 3: bubbleSort(arr); break;
            case 4: countingSort(arr); break;
            case 5: mergeSort(arr); break;
            case 6: quickSort(arr); break;
            default: System.out.println("Opción inválida");
        }

        System.out.println("Arreglo ordenado:");
        System.out.println(Arrays.toString(arr));
    }
}
