import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa o algoritmo Heap Sort e mede o tempo de execução.
 *
 * @author Gabriel Consul Moreno
 * Date: 23-06-2024
 */
public class HeapSort extends Sort {
    // Variável que armazena o tempo em nanosegundos da última execução do algoritmo
    private static long nanoTime;

    // Lista que armazena o tempo de cada execução individual do algoritmo
    private static List<Long> allTimesList = new ArrayList<>();

    /**
     * Método que reorganiza o array em um heap máximo.
     *
     * @param array Array a ser reorganizado
     * @param i Índice do nó a ser heapificado
     * @param n Tamanho do heap
     * @param <T> Tipo dos elementos do array, que devem ser comparáveis
     */
    private static <T extends Comparable<? super T>>
    void maxHeapify(T[] array, int i, int n) {
        int max = 2 * i + 1;
        if (max + 1 < n && array[max].compareTo(array[max + 1]) < 0) max++;
        if (max < n && array[max].compareTo(array[i]) > 0) {
            exchange(array, i, max);
            maxHeapify(array, max, n);
        }
    }

    /**
     * Método que constrói um heap máximo a partir de um array.
     *
     * @param array Array a ser convertido em heap máximo
     * @param <T> Tipo dos elementos do array, que devem ser comparáveis
     */
    private static <T extends Comparable<? super T>>
    void buildMaxHeap(T[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeapify(array, i, array.length);
        }
    }

    /**
     * Método que realiza a ordenação de um array utilizando o algoritmo Heap Sort.
     *
     * @param array Array a ser ordenado
     * @param <T> Tipo dos elementos do array, que devem ser comparáveis
     * @return O array ordenado
     */
    public static <T extends Comparable<? super T>>
    T[] heapSort(T[] array) {
        long startTime = System.nanoTime();
        buildMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            exchange(array, 0, i);
            maxHeapify(array, 0, i);
        }
        nanoTime = System.nanoTime() - startTime;
        allTimesList.add(nanoTime);
        return array;
    }

    /**
     * Retorna o tempo em nanosegundos da última execução do algoritmo Heap Sort.
     *
     * @return Tempo em nanosegundos da última execução
     */
    public static long getNanoTime() {
        return nanoTime;
    }

    /**
     * Retorna uma lista com os tempos de cada execução individual do algoritmo Heap Sort.
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
