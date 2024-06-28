import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa o algoritmo Shell Sort e mede o tempo de execução.
 *
 * @author Gabriel Consul Moreno
 * Date: 23-06-2024
 */
public class ShellSort extends Sort {
    // Variável que armazena o tempo em nanosegundos da última execução do algoritmo
    private static long nanoTime;

    // Lista que armazena o tempo de cada execução individual do algoritmo
    private static List<Long> allTimesList = new ArrayList<>();

    /**
     * Método que realiza a ordenação de um array utilizando o algoritmo Shell Sort.
     *
     * @param array Array a ser ordenado
     * @param <T> Tipo dos elementos do array, que devem ser comparáveis
     * @return O array ordenado
     */
    public static <T extends Comparable<? super T>>
    T[] shellSort(T[] array) {
        int h = 1;
        long startTime = System.nanoTime();
        // Calcula o maior valor de h
        while (3 * h + 1 < array.length) {
            h = 3 * h + 1;
        }
        // Reduz h até 1, realizando as trocas necessárias
        while (h > 0) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h && array[j - h].compareTo(array[j]) > 0; j -= h) {
                    exchange(array, j - h, j);
                }
            }
            h /= 3;
        }
        nanoTime = System.nanoTime() - startTime;
        allTimesList.add(nanoTime);
        return array;
    }

    /**
     * Retorna o tempo em nanosegundos da última execução do algoritmo Shell Sort.
     *
     * @return Tempo em nanosegundos da última execução
     */
    public static long getNanoTime() {
        return nanoTime;
    }

    /**
     * Retorna uma lista com os tempos de cada execução individual do algoritmo Shell Sort.
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
