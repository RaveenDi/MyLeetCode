import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{38, 21, 47, 50, 24, 18, 24, 4, 22, 10, 23, 23, 12};

        array = bubbleSort(array);
        Arrays.stream(array).forEach(n -> System.out.print(" " + n));
    }

    public static int[] bubbleSort(int[] array) {
        boolean swapped = false;
        int round = 0;

        for (int i = 0; i<array.length -1; i++) {
            for (int j = 0; j < array.length - round - 1; j++) {
                if (array[j] > array[j+1]) {
                    array = swap(array, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

    public static int[] swap(int[] array, int firstIndex, int secondIndex){
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
        return array;
    }
}