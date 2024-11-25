import java.util.* ;
import java.io.*;

public class RotateLeftBy1 {

    static int[] rotateArray(int[] arr, int n) {
        // Create a new array to store the rotated result
        int[] rotatedArray = new int[n];

        // Shift all elements to the left by one
        for (int i = 1; i < n; i++) {
            rotatedArray[i - 1] = arr[i];
        }

        // Move the first element to the last position
        rotatedArray[n - 1] = arr[0];

        // Return the rotated array
        return rotatedArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        System.out.println("rortaing array to left by k pos");

        int[] result = rotateArray(arr, n);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
