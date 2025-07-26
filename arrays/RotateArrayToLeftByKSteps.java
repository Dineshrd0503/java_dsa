package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArrayToLeftByKSteps {

    /**
     * Given an array 'arr' with 'n' elements, the task is to rotate the array to the left by 'k' steps, where 'k' is non-negative.
     *
     * Example:
     * 'arr' = [1,2,3,4,5]
     * 'k' = 1  rotated array = [2,3,4,5,1]
     * 'k' = 2  rotated array = [3,4,5,1,2]
     * 'k' = 3  rotated array = [4,5,1,2,3] and so on.
     *
     * Input Format:
     * The first line contains an integer 'n' representing the size of the array.
     * The second line contains 'n' space-separated integers representing the elements of the array.
     * The last line contains an integer 'k' representing the number of times the array has to be rotated in the left direction.
     *
     * Output Format:
     * The output contains 'n' space-separated integers representing the Rotated array elements.
     *
     * Note:-
     * You don’t need to print anything. Just implement the given function.
     *
     * Sample Input 1:
     * 8
     * 7 5 2 11 2 43 1 1
     * 2
     *
     * Sample Output 1:
     * 2 11 2 43 1 1 7 5
     *
     * Explanation of Sample Input 1:
     * Rotate 1 steps to the left: 5 2 11 2 43 1 1 7
     * Rotate 2 steps to the left: 2 11 2 43 1 1 7 5
     *
     * Sample Input 2:
     * 4
     * 5 6 7 8
     * 3
     *
     * Sample Output 2:
     * 8 5 6 7
     *
     * Explanation of Sample Input 2:
     * Rotate 1 steps to the left: 6 7 8 5
     * Rotate 2 steps to the left: 7 8 5 6
     * Rotate 2 steps to the left: 8 5 6 7
     *
     * Expected Time Complexity:
     * O(n), where ‘n’ is the size of the array ‘arr’ and ‘k’ is the number of rotations.
     *
     * Constraints:
     * 1 <= 'n' <= 10^3
     * 1 <= 'arr'[i] <= 10^9
     * 1 <= 'k' < 'n'
     */
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {

        int n = arr.size();
        k = k % n; // Crucial for handling k > n

        reverse(arr, 0, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);

        return arr;
    }

    private static void reverse(ArrayList<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Sample Test Cases
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(7, 5, 2, 11, 2, 43, 1, 1));
        int k1 = 2;
        System.out.println("Input Array: " + arr1 + ", k = " + k1);
        System.out.println("Rotated Array: " + rotateArray(new ArrayList<>(arr1), k1)); // Create a copy to avoid modifying the original

        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        int k2 = 3;
        System.out.println("\nInput Array: " + arr2 + ", k = " + k2);
        System.out.println("Rotated Array: " + rotateArray(new ArrayList<>(arr2), k2)); // Create a copy

        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int k3 = 1;
        System.out.println("\nInput Array: " + arr3 + ", k = " + k3);
        System.out.println("Rotated Array: " + rotateArray(new ArrayList<>(arr3), k3));
    }
}
