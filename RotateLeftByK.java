import java.util.* ;
import java.io.*;

public class RotateLeftByK {

    static int[] rotateArray(int[] arr, int n, int k) {
        // If k is greater than the array length, use k % n for optimized rotations
        k = k % n;

        // Create a new array to store the rotated result
        int[] rotatedArray = new int[n];

        // Copy the second part of the array (from index k to the end) to the beginning
        for (int i = k; i < n; i++) {
            rotatedArray[i - k] = arr[i];
        }

        // Copy the first part of the array (from index 0 to k-1) to the end
        for (int i = 0; i < k; i++) {
            rotatedArray[n - k + i] = arr[i];
        }

        return rotatedArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int k = 2; // Number of positions to rotate
        System.out.println("rotate arr to left by k pos");

        int[] result = rotateArray(arr, n, k);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
