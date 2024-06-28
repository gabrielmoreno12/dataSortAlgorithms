import java.util.Arrays;

/**
 * Classe que implementa métodos auxiliares para criação e manipulação de arrays utilizados em algoritmos de ordenação.
 *
 * @author Gabriel Consul Moreno
 * Date: 23-06-2024
 */
public class Sort {
    /**
     * Realiza as trocas entre os itens do array, será usado nos métodos de ordenação.
     *
     * @param array Array utilizado para uso dos itens
     * @param i Primeiro item a ser trocado de lugar
     * @param j Segundo item a ser trocado de lugar
     */
    public static <T extends Comparable<? super T>>
    void exchange(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * Cria um array de inteiros ordenado de forma crescente sem repetições.
     *
     * @param arrayLength Tamanho do array a ser criado
     * @return Array de inteiros ordenado de forma crescente
     */
    public static Integer[] createArrayNoRepeatsAscending(int arrayLength) {
        Integer[] array = new Integer[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Cria um array de inteiros ordenado de forma decrescente sem repetições.
     *
     * @param arrayLength Tamanho do array a ser criado
     * @return Array de inteiros ordenado de forma decrescente
     */
    public static Integer[] createArrayNoRepeatsDescending(int arrayLength) {
        Integer[] array = new Integer[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayLength - i - 1;
        }
        return array;
    }

    /**
     * Cria um array de inteiros desordenado com valores aleatórios, permitindo repetições.
     *
     * @param arrayLength Tamanho do array a ser criado
     * @return Array de inteiros com valores aleatórios
     */
    public static Integer[] createRandomArray(int arrayLength) {
        Integer[] array = new Integer[arrayLength];
        int random;
        for (int i = 0; i < array.length; i++) {
            random = (int) (Math.random() * arrayLength);
            array[i] = random;
        }
        return array;
    }

    /**
     * Cria um array de inteiros desordenado com valores aleatórios, sem permitir repetições.
     *
     * @param arrayLength Tamanho do array a ser criado
     * @return Array de inteiros com valores aleatórios e sem repetições
     */
    public static Integer[] createRandomArrayNoRepeats(int arrayLength) {
        Integer[] array = new Integer[arrayLength];
        int random;
        for (int i = 0; i < array.length; i++) {
            do {
                random = (int) (Math.random() * arrayLength);
            } while (Arrays.asList(array).contains(random));
            array[i] = random;
        }
        return array;
    }
}
