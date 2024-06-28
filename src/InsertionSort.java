import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa o algoritmo Insertion Sort e mede o tempo de execução.
 *
 * @author Gabriel Consul Moreno
 * Date: 23-06-2024
 */
public class InsertionSort extends Sort {
    // Variável que armazena o tempo em nanosegundos da última execução do algoritmo
    private static long nanoTime;

    // Lista que armazena o tempo de cada execução individual do algoritmo
    private static List<Long> allTimesList = new ArrayList<>();

    /**
     * Método que realiza a ordenação de um array utilizando o algoritmo Insertion Sort.
     *
     * @param array Array a ser ordenado
     * @param <T> Tipo dos elementos do array, que devem ser comparáveis
     * @return O array ordenado
     */
    public static <T extends Comparable<? super T>>
    T[] insertionSort(T[] array) {
        long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1].compareTo(array[j]) > 0; j--) {
                exchange(array, j - 1, j);
            }
        }
        nanoTime = System.nanoTime() - startTime;
        allTimesList.add(nanoTime);
        return array;
    }

    /**
     * Retorna o tempo em nanosegundos da última execução do algoritmo Insertion Sort.
     *
     * @return Tempo em nanosegundos da última execução
     */
    public static long getNanoTime() {
        return nanoTime;
    }

    /**
     * Retorna uma lista com os tempos de cada execução individual do algoritmo Insertion Sort.
     *
     * @return Lista de tempos de execução em nanosegundos
     */
    public static List<Long> getAllTimesList() {
        return allTimesList;
    }

    /**
     * Reseta os tempos de execução armazenados.
     */
    public static void resetTimes() {
        nanoTime = 0;
        allTimesList.clear();
    }
}
