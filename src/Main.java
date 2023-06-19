import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{38, 21, 47, 50, 24, 18, 24, 4, 22, 10, 23, 23, 12};

        long startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        long endTime = System.nanoTime();

        System.out.print( "Array    : ");
        Arrays.stream(array).forEach(n -> System.out.print(n + " "));

        float duration = (endTime - startTime);
        System.out.println( "\nDuration : " + duration/1000000);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int p = partitions(array, low, high);

            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    public static int partitions(int[] array, int low, int high) {
        int pvt = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            i++;
            while (i<=high && array[i] < pvt) {
                i++;
            }

            while (j>=low && array[j] > pvt){
                j--;
            }

            if (i<=high && i<j) {
                swap(array, i, j);
            }
        }
        swap(array, low, j);
        return j;
    }

    public static int[] mergeSort(int[] array) {
        sort(array, 0, array.length-1);
        return array;
    }

    public static void sort(int[] array, int l, int r) {
        if(l < r) {
            int m = l + ( r - l ) / 2;

            sort(array, l, m);
            sort(array, m + 1, r);

            merge(array, l, m, r);
        }
    }
    public static void merge(int[] array, int l, int m, int r) {
        int leftSize = m - l + 1;
        int rightSize = r - m;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for(int i = 0; i < leftSize; i++)
            left[i] = array[l + i];
        for (int j = 0; j < rightSize; j++)
            right[j] = array[m + 1 + j];

        int i = 0,j=0;

        while ((i< leftSize) && (j<rightSize)) {
            if (left[i] < right[j]) {
                array[l + i + j] = left[i];
                i++;
            } else {
                array[l + i + j] = right[j];
                j++;
            }
        }

        while (i< leftSize) {
            array[l + i + j] = left[i];
            i++;
        }

        while (j<rightSize) {
            array[l + i + j] = right[j];
            j++;
        }

    }


    public static int[] insertionSort(int[] array) {
        int value;
        for (int i = 1; i < array.length; i++) {
            value = array[i];
            int j = i-1;
            while ((j >= 0) && array[j] > value) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = value;
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minimum = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minimum] > array[j]) {
                    minimum = j;
                }
            }
            if (i != minimum) {
                array = swap(array, i, minimum);
            }
        }
        return array;
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