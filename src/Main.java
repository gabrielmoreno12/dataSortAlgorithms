import java.util.*;

/**
 * <p>
 * Classe principal que executa cenários de teste para diferentes algoritmos de ordenação.
 * Estende a classe Sort para ter acesso aos métodos de ordenação.
 * Utiliza arrays de diferentes tamanhos e configurações para avaliação de desempenho dos algoritmos.
 * Os cenários incluem arrays ordenados em ordem crescente, decrescente, aleatórios com e sem repetições.
 * Calcula e imprime o tempo médio de execução de cada algoritmo dentro de um intervalo estatístico.
 * <p>
 * Cenários:
 * 1. Array ordenado em ordem crescente sem valores repetidos
 * 2. Array ordenado em ordem decrescente sem valores repetidos
 * 3. Array aleatório sem valores repetidos
 * 4. Array aleatório com valores repetidos
 * <p>
 * Algoritmos de ordenação utilizados:
 * - BubbleSort
 * - InsertionSort
 * - SelectionSort
 * - HeapSort
 * - ShellSort
 * - MergeSort
 * - QuickSort
 * <p>
 * Cada método de ordenação é executado para cada cenário e os tempos são medidos e impressos.
 * Ao final de cada cenário, é impresso o tempo médio de execução de cada algoritmo.
 * <p>
 * Os métodos calculateMean, calculateVariance, calculateStandardDeviation e calculateAverageWithinInterval
 * são utilizados para calcular estatísticas sobre os tempos de execução dos algoritmos.
 * <p>
 * A classe Main também possui métodos para reiniciar os tempos de execução de todos os algoritmos após cada cenário.
 *
 * @author Gabriel Consul Moreno
 * Date: 23-06-2024
 */
public class Main extends Sort {

    private static final int INITIAL_LENGTH = 128;
    private static final int FINAL_LENGTH = 65536;
    private static final String[] SORTING_METHODS = {
            "BubbleSort", "InsertionSort", "SelectionSort",
            "HeapSort", "ShellSort", "MergeSort", "QuickSort"
    };
    private static int i = 1;

    public static void main(String[] args) {
        executeFirstScenario();
        resetAll();

        executeSecondScenario();
        resetAll();

        executeThirdScenario();
        resetAll();

        executeFourthScenario();
        resetAll();
    }

    // Cenário 1 - Array ordenado em ordem crescente sem valores repetidos
    private static void executeFirstScenario() {
        System.out.println("\nCenário 1 - Array ordenado em ordem crescente sem valores repetidos");
        for (int arrayLength = INITIAL_LENGTH;
             arrayLength <= FINAL_LENGTH; arrayLength *= 2) {
            Integer[] array = createArrayNoRepeatsAscending(arrayLength);
            System.out.println("[" + i + "] ARRAY LENGTH: " + array.length);
            i++;
            executeSortingMethods(array);
        }
        printAverageTimes();
    }

    // Cenário 2 - Array ordenado em ordem decrescente sem valores repetidos
    private static void executeSecondScenario() {
        System.out.println("\nCenário 2 - Array ordenado em ordem decrescente sem valores repetidos");
        for (int arrayLength = INITIAL_LENGTH;
             arrayLength <= FINAL_LENGTH; arrayLength *= 2) {
            Integer[] array = createArrayNoRepeatsDescending(arrayLength);
            System.out.println("[" + i + "] ARRAY LENGTH: " + array.length);
            i++;
            executeSortingMethods(array);
        }
        printAverageTimes();
    }

    // Cenário 3 - Array aleatório sem valores repetidos
    private static void executeThirdScenario() {
        System.out.println("\nCenário 3 - Array aleatório sem valores repetidos");
        for (int arrayLength = INITIAL_LENGTH;
             arrayLength <= FINAL_LENGTH; arrayLength *= 2) {
            Integer[] array = createRandomArrayNoRepeats(arrayLength);
            System.out.println("[" + i + "] ARRAY LENGTH: " + array.length);
            i++;
            executeSortingMethods(array);
        }
        printAverageTimes();
    }

    // Cenário 4 - Array aleatório com valores repetidos
    private static void executeFourthScenario() {
        System.out.println("\nCenário 4 - Array aleatório com valores repetidos");
        for (int arrayLength = INITIAL_LENGTH;
             arrayLength <= FINAL_LENGTH; arrayLength *= 2) {
            Integer[] array = createRandomArray(arrayLength);
            System.out.println("[" + i + "] ARRAY LENGTH: " + array.length);
            i++;
            executeSortingMethods(array);
        }
        printAverageTimes();
    }

    /**
     * Método que executa todos os métodos de ordenação para um dado array.
     *
     * @param array Array a ser ordenado
     */
    private static void executeSortingMethods(Integer[] array) {
        for (String method : SORTING_METHODS) {
            Integer[] arrayCopy = Arrays.copyOf(array, array.length);
            switch (method) {
                case "BubbleSort" -> {
                    BubbleSort.bubbleSort(arrayCopy);
                    System.out.println(" - BubbleSort:       " + BubbleSort.getNanoTime() + " ns");
                }
                case "InsertionSort" -> {
                    InsertionSort.insertionSort(arrayCopy);
                    System.out.println(" - InsertionSort:    " + InsertionSort.getNanoTime() + " ns");
                }
                case "SelectionSort" -> {
                    SelectionSort.selectionSort(arrayCopy);
                    System.out.println(" - SelectionSort:    " + SelectionSort.getNanoTime() + " ns");
                }
                case "HeapSort" -> {
                    HeapSort.heapSort(arrayCopy);
                    System.out.println(" - HeapSort:         " + HeapSort.getNanoTime() + " ns");
                }
                case "ShellSort" -> {
                    ShellSort.shellSort(arrayCopy);
                    System.out.println(" - ShellSort:        " + ShellSort.getNanoTime() + " ns");
                }
                case "MergeSort" -> {
                    MergeSort.mergeSort(arrayCopy);
                    System.out.println(" - MergeSort:        " + MergeSort.getNanoTime() + " ns");
                }
                case "QuickSort" -> {
                    QuickSort.quickSort(arrayCopy);
                    System.out.println(" - QuickSort:        " + QuickSort.getNanoTime() + " ns");
                }
            }
        }
    }

    /**
     * Método que imprime o tempo médio de execução de cada algoritmo de ordenação.
     */
    private static void printAverageTimes() {
        try {
            System.out.println("\nBubbleSort Average Time:    " + calculateAverageWithinInterval(BubbleSort.getAllTimesList()) + " ns");
            System.out.println("InsertionSort Average Time: " + calculateAverageWithinInterval(InsertionSort.getAllTimesList()) + " ns");
            System.out.println("SelectionSort Average Time: " + calculateAverageWithinInterval(SelectionSort.getAllTimesList()) + " ns");
            System.out.println("HeapSort Average Time:      " + calculateAverageWithinInterval(HeapSort.getAllTimesList()) + " ns");
            System.out.println("ShellSort Average Time:     " + calculateAverageWithinInterval(ShellSort.getAllTimesList()) + " ns");
            System.out.println("MergeSort Average Time:     " + calculateAverageWithinInterval(MergeSort.getAllTimesList()) + " ns");
            System.out.println("QuickSort Average Time:     " + calculateAverageWithinInterval(QuickSort.getAllTimesList()) + " ns");
        } catch (IllegalArgumentException e) {
            System.err.println("Error calculating averages: " + e.getMessage());
        }
    }

    /**
     * Método que calcula a média de uma lista de tempos.
     *
     * @param list Lista de tempos
     * @return Média dos tempos
     */
    private static long calculateMean(List<Long> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty");
        }
        long sum = 0;
        for (Long i : list) {
            sum += i;
        }
        return sum / list.size();
    }

    /**
     * Método que calcula a variância de uma lista de tempos.
     *
     * @param list Lista de tempos
     * @return Variância dos tempos
     */
    private static long calculateVariance(List<Long> list) {
        if (list.size() < 2) {
            throw new IllegalArgumentException("List must have at least two elements to calculate variance.");
        }
        long mean = calculateMean(list);
        double sumOfSquares = 0;
        for (Long time : list) {
            double diff = time - mean;
            sumOfSquares += diff * diff;
        }
        return (long) (sumOfSquares / (list.size() - 1));
    }

    /**
     * Método que calcula o desvio padrão de uma lista de tempos.
     *
     * @param list Lista de tempos
     * @return Desvio padrão dos tempos
     */
    private static long calculateStandardDeviation(List<Long> list) {
        double variance = calculateVariance(list);
        return (long) Math.sqrt(variance);
    }

    /**
     * Método que calcula a média dos tempos dentro de um intervalo válido.
     *
     * @param list Lista de tempos
     * @return Média dos tempos dentro do intervalo
     */
    private static long calculateAverageWithinInterval(List<Long> list) {
        long mean = calculateMean(list);
        long stdDeviation = calculateStandardDeviation(list);
        long lowerBound = mean - 3 * stdDeviation;
        long upperBound = mean + 3 * stdDeviation;

        List<Long> valuesWithinInterval = new ArrayList<>();
        for (Long time : list) {
            if (time >= lowerBound && time <= upperBound) {
                valuesWithinInterval.add(time);
            }
        }
        // Se não houver valores dentro do intervalo, retorna a média de todos os valores
        if (valuesWithinInterval.isEmpty()) {
            valuesWithinInterval = list;
        }
        long sum = 0;
        for (Long value : valuesWithinInterval) {
            sum += value;
        }
        return sum / valuesWithinInterval.size();
    }

    /**
     * Método que reinicia os tempos de execução de todos os algoritmos.
     */
    private static void resetAll() {
        BubbleSort.resetTimes();
        InsertionSort.resetTimes();
        SelectionSort.resetTimes();
        HeapSort.resetTimes();
        ShellSort.resetTimes();
        MergeSort.resetTimes();
        QuickSort.resetTimes();
    }
}
