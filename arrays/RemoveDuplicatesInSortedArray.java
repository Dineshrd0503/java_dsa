package arrays;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {

    /**
     * You are given a sorted integer array 'arr' of size 'n'.
     * You need to remove the duplicates from the array such that each element appears only once.
     * Return the length of this new array.
     *
     * Note:
     * Do not allocate extra space for another array. You need to do this by modifying the given
     * input array in place with O(1) extra memory.
     *
     * For example:
     * 'n' = 5, 'arr' = [1 2 2 2 3].
     * The new array will be [1 2 3].
     * So our answer is 3.
     *
     * Detailed explanation ( Input/output format, Notes, Images )
     *
     * Input format:
     *
     * The first line contains an integer ‘n’ denoting the number of elements in the array.
     *
     * The second line contains ‘n’ space-separated integers representing the elements of the array.
     *
     * Output format:
     *
     * Return the length of the modified array.
     *
     * Note:
     *
     * You don't need to print anything, it has already been taken care of. Just Implement the given function.
     *
     * Sample input 1:
     * 10
     * 1 2 2 3 3 3 4 4 5 5
     *
     * Sample output 1:
     * 5
     *
     * Explanation of sample input 1:
     * The new array will be [1 2 3 4 5].
     * So our answer is 5.
     *
     * Sample input 2:
     * 9
     * 1 1 2 3 3 4 5 5 5
     *
     * Sample output 2:
     * 5
     *
     * Expected time complexity:
     * The expected time complexity is O(n).
     *
     * Constraints :
     * 1 <= 'n' <= 10^6
     * -10^9 <= 'arr[i]' <=10^9
     *
     * Where ‘arr[i]’ is the value of elements of the array.
     *
     * Time limit: 1 sec
     */
    public static int removeDuplicates(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        int i = 0; // Index for the next unique element
        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j]; // Move the unique element to its correct position
            }
        }
        return i + 1; // Length of the modified array
    }

    public static void main(String[] args) {
        // Sample Test Cases
        int[] arr1 = {1, 2, 2, 3, 3, 3, 4, 4, 5, 5};
        int n1 = arr1.length;
        int result1 = removeDuplicates(arr1, n1);
        System.out.println("Sample Output 1: " + result1); // Expected Output: 5
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOfRange(arr1, 0, result1))); // Print the modified array

        int[] arr2 = {1, 1, 2, 3, 3, 4, 5, 5, 5};
        int n2 = arr2.length;
        int result2 = removeDuplicates(arr2, n2);
        System.out.println("Sample Output 2: " + result2); // Expected Output: 5
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOfRange(arr2, 0, result2))); // Print the modified array

        int[] arr3 = {1, 2, 2, 2, 3};
        int n3 = arr3.length;
        int result3 = removeDuplicates(arr3, n3);
        System.out.println("Sample Output 3: " + result3);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOfRange(arr3, 0, result3)));

        int[] arr4 = {1,1,1,1,1};
        int n4 = arr4.length;
        int result4 = removeDuplicates(arr4, n4);
        System.out.println("Sample output 4:" + result4);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOfRange(arr4, 0, result4)));



        // Static Input Example (You can modify this to take user input)
       /* int n = 10;
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 5, 5}; */

        //To properly simulate the problem:
        // 1. You would read n from standard input
        // 2. You would read the array elements from Standard input separated by spaces.

    }
}
