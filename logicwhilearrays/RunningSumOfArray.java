package logicwhilearrays;
/*
Given an integer array, compute its running sum. The running sum at each index is the sum of all elements from the start up to that index.

Sample Input:
arr = {1, 2, 3, 4}
Sample Output:
1 3 6 10
 */
public class RunningSumOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2,3,4};
        int n = arr.length;;

        // Calculate the running sum
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
