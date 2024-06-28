import java.util.ArrayList;
import java.util.List;

public class SelectionSort extends Sort {
    private static long nanoTime;
    private static long allTimes;
    private static List<Long> allTimesList = new ArrayList<>();



    public static <T extends Comparable<? super T>> T[]
    selectionSort(T[] array) {

        long startTime = System.nanoTime();
        for (int min, i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }
            exchange(array, i, min);
        }
        long endTime = System.nanoTime();
        nanoTime = endTime - startTime;
        allTimes += nanoTime;
        allTimesList.add(nanoTime);

        return array;
    }

    public static long getNanoTime() {
        return nanoTime;
    }

    public static long getAllTimes() {
        return allTimes;
    }

    public static List<Long> getAllTimesList() {
        return allTimesList;
    }
    public static void resetTimes() {
        nanoTime = 0;
        allTimes = 0;
        allTimesList.clear();
    }

}
