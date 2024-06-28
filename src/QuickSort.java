import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Classe que implementa o algoritmo de ordenação Quick Sort.
 *
 * @author Gabriel Consul Moreno
 * Date: 23-06-2024
 */
public class QuickSort extends Sort {
    private static long nanoTime;
    private static List<Long> allTimesList = new ArrayList<>();

    /**
     * Método principal que executa o algoritmo Quick Sort.
     *
     * @param array Array a ser ordenado
     * @return Array ordenado
     */
    public static <T extends Comparable<? super T>>
    T[] quickSort(T[] array) {
        long start = System.nanoTime();
        iterativeQuickSort(array, 0, array.length - 1);
        nanoTime = System.nanoTime() - start;
        allTimesList.add(nanoTime);
        return array;
    }

    /**
     * Método que realiza o Quick Sort de forma iterativa.
     *
     * @param array Array a ser ordenado
     * @param left Índice inicial
     * @param right Índice final
     */
    private static <T extends Comparable<? super T>>
    void iterativeQuickSort(T[] array, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            int pivot = partition(array, left, right);
            if (pivot - 1 > left) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < right) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }

    /**
     * Método que realiza a partição do array para o Quick Sort.
     *
     * @param array Array a ser ordenado
     * @param low Índice inicial
     * @param high Índice final
     * @return Índice do pivô
     */
    private static <T extends Comparable<? super T>>
    int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                exchange(array, i, j);
            }
        }
        exchange(array, i + 1, high);
        return i + 1;
    }

    /**
     * Obtém o tempo gasto na última execução do Quick Sort.
     *
     * @return Tempo em nanossegundos
     */
    public static long getNanoTime() {
        return nanoTime;
    }

    /**
     * Obtém a lista de tempos de todas as execuções do Quick Sort.
     *
     * @return Lista de tempos em nanossegundos
     */
    public static List<Long> getAllTimesList() {
        return allTimesList;
    }

    /**
     * Reseta os tempos das execuções do Quick Sort.
     */
    public static void resetTimes() {
        nanoTime = 0;
        allTimesList.clear();
    }
}
