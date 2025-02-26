package codingninjas;
// Problem statement
// You are given an array 'ARR' consisting of 'N' non-negative integers, your task is to copy the elements of 'ARR' into another array 'COPY_ARR' in reverse order.

// For example:
// If 'ARR' contains the following elements [ 1, 2, 3, 4, 5 ], then you should return another array that is equal to [ 5, 4, 3, 2, 1].

// Detailed explanation (Input/output format, Notes, Images)
// Constraints :
// 1 <= T <= 10^2
// 1 <= N <= 10^4
// 0 <= ARR[i] <= 10^9

// Time Limit: 1 sec

// Sample Input 1 :
// 2
// 5
// 1 2 3 4 5
// 4
// 5 8 2 1

// Sample Output 1 :
// 5 4 3 2 1
// 1 2 8 5

// Explanation For Sample Input 1 :
// The reverse of [1, 2, 3, 4, 5] is [5, 4, 3, 2, 1]
// The reverse of [5, 8, 2, 1] is [1, 2, 8, 5].

// Sample Input 2 :
// 3
// 3
// 3 2 1
// 4
// 8  6 2 4
// 5
// 1 3 5 4 2

// Sample Output 2 :
// 1 2 3
// 4 2 6 8
// 2 4 5 3 1

// Explanation For Sample Input 2 :
// The reverse of [3, 2, 1] is [1, 2, 3].
// The reverse of [8, 6, 2, 4] is [4, 2, 6, 8].
// The reverse of [1, 3, 5, 4, 2] is [2, 4, 5, 3, 1].






import java.util.Arrays;

public class CopyAndReverseArray {

    public static int[] copyAndReverse(int[] arr, int n) {
        // Create a new array to hold the reversed elements
        int[] copyArr = new int[n];

        // Copy elements from arr to copyArr in reverse order
        for (int i = 0; i < n; i++) {
            copyArr[i] = arr[n - 1 - i]; // Reverse order copy
        }

        return copyArr; // Return the reversed array
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] reversedArr1 = copyAndReverse(arr1, arr1.length);
        System.out.println(Arrays.toString(reversedArr1)); // Output: [5, 4, 3, 2, 1]

        // Test case 2
        int[] arr2 = {5, 8, 2, 1};
        int[] reversedArr2 = copyAndReverse(arr2, arr2.length);
        System.out.println(Arrays.toString(reversedArr2)); // Output: [1, 2, 8, 5]

        // Additional test cases
        int[] arr3 = {3, 2, 1};
        int[] reversedArr3 = copyAndReverse(arr3, arr3.length);
        System.out.println(Arrays.toString(reversedArr3)); // Output: [1, 2, 3]

        int[] arr4 = {8, 6, 2, 4};
        int[] reversedArr4 = copyAndReverse(arr4, arr4.length);
        System.out.println(Arrays.toString(reversedArr4)); // Output: [4, 2, 6, 8]
    }
}
