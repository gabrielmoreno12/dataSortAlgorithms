import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa o algoritmo Bubble Sort e mede o tempo de execução.
 *
 * @author Gabriel Consul Moreno
 * Date: 23-06-2024
 */
public class BubbleSort extends Sort {
    // Variável que armazena o tempo em nanosegundos da última execução do algoritmo
    private static long nanoTime = 0;

    // Lista que armazena o tempo de cada execução individual do algoritmo
    private static List<Long> allTimesList = new ArrayList<>();

    /**
     * Método que realiza a ordenação de um array utilizando o algoritmo Bubble Sort.
     *
     * @param array Array a ser ordenado
     * @param <T> Tipo dos elementos do array, que devem ser comparáveis
     * @return O array ordenado
     */
    public static <T extends Comparable<? super T>>
    T[] bubbleSort(T[] array) {
        boolean exchange;
        long startTime = System.nanoTime();
        do {
            exchange = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    exchange(array, i, i + 1);
                    exchange = true;
                }
            }
        } while (exchange);
        nanoTime = System.nanoTime() - startTime;
        allTimesList.add(nanoTime);
        return array;
    }

    /**
     * Retorna o tempo em nanosegundos da última execução do algoritmo Bubble Sort.
     *
     * @return Tempo em nanosegundos da última execução
     */
    public static long getNanoTime() {
        return nanoTime;
    }

    /**
     * Retorna uma lista com os tempos de cada execução individual do algoritmo Bubble Sort.
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
