import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        int[] a={45,6,31,87,3};
        System.out.println("bfreo sorting");
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println("after sorting");
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
