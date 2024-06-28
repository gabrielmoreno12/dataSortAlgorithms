import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa o algoritmo de ordenação Merge Sort.
 *
 * @author Gabriel Consul Moreno
 * Date: 23-06-2024
 */
public class MergeSort extends Sort {
    private static long nanoTime;
    private static List<Long> allTimesList = new ArrayList<>();

    /**
     * Método auxiliar que realiza a junção dos sub-arrays ordenados.
     *
     * @param array Array original a ser ordenado
     * @param aux Array auxiliar utilizado na junção
     * @param low Índice inicial do sub-array
     * @param middle Índice do meio do sub-array
     * @param high Índice final do sub-array
     */
    private static <T extends Comparable<? super T>>
    void conquer(T[] array, T[] aux, int low, int middle, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }
        int i = low, j = middle + 1;
        for (int k = low; k <= high; k++) {
            if (i > middle) {
                array[k] = aux[j++];
            } else if (j > high) {
                array[k] = aux[i++];
            } else if (array[j].compareTo(aux[i]) < 0) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    /**
     * Método auxiliar que divide o array em sub-arrays menores para serem ordenados.
     *
     * @param array Array original a ser ordenado
     * @param aux Array auxiliar utilizado na divisão
     * @param low Índice inicial do sub-array
     * @param high Índice final do sub-array
     */
    private static <T extends Comparable<? super T>>
    void divide(T[] array, T[] aux, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        divide(array, aux, low, middle);
        divide(array, aux, middle + 1, high);
        conquer(array, aux, low, middle, high);
    }

    /**
     * Método principal que executa o algoritmo Merge Sort.
     *
     * @param array Array a ser ordenado
     * @return Array ordenado
     */
    public static <T extends Comparable<? super T>>
    T[] mergeSort(T[] array) {
        long start = System.nanoTime();
        T[] aux = (T[]) new Comparable[array.length];
        divide(array, aux, 0, array.length - 1);
        nanoTime = System.nanoTime() - start;
        allTimesList.add(nanoTime);
        return array;
    }

    /**
     * Obtém o tempo gasto na última execução do Merge Sort.
     *
     * @return Tempo em nanossegundos
     */
    public static long getNanoTime() {
        return nanoTime;
    }

    /**
     * Obtém a lista de tempos de todas as execuções do Merge Sort.
     *
     * @return Lista de tempos em nanossegundos
     */
    public static List<Long> getAllTimesList() {
        return allTimesList;
    }

    /**
     * Reseta os tempos das execuções do Merge Sort.
     */
    public static void resetTimes() {
        nanoTime = 0;
        allTimesList.clear();
    }
}

