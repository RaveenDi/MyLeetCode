import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{38, 21, 47, 50, 24, 18, 24, 4, 22, 10, 23, 23, 12};

        long startTime = System.nanoTime();
        array = mergeSort(array);
        long endTime = System.nanoTime();

        System.out.print( "Array    : ");
        Arrays.stream(array).forEach(n -> System.out.print(n + " "));

        float duration = (endTime - startTime);
        System.out.println( "\nDuration : " + duration/1000000);
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
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = array[l+i];
        for (int i = 0; i< n2; i++)
            right[i] = array[m+i+1];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            }
            else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
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