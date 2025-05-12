package wiprointerviewforda;
import java.util.*;

public class RotateList {
    // Problem: Rotate a list to the right by k steps
    // Sample Test Cases:
    // Input: arr = [1, 2, 3, 4, 5], k = 2
    // Output: [4, 5, 1, 2, 3]
    // Input: arr = [1, 2, 3], k = 3
    // Output: [1, 2, 3]
    // Input: arr = [], k = 1
    // Output: []

    public static void rotate(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return;
        k = k % arr.length;
        if (k < 0) k += arr.length;

        // Reverse entire array
        reverse(arr, 0, arr.length - 1);
        // Reverse first k elements
        reverse(arr, 0, k - 1);
        // Reverse rest
        reverse(arr, k, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println("Test Case 1:");
        rotate(arr1, k1);
        System.out.println(Arrays.toString(arr1));

        // Test Case 2
        int[] arr2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("\nTest Case 2:");
        rotate(arr2, k2);
        System.out.println(Arrays.toString(arr2));

        // Test Case 3
        int[] arr3 = {};
        int k3 = 1;
        System.out.println("\nTest Case 3:");
        rotate(arr3, k3);
        System.out.println(Arrays.toString(arr3));
    }
}