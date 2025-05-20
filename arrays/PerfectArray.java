package arrays;

public class PerfectArray {

    // Problem: Perfect Array
    // You are given an array 'A' of length 'N' consisting of positive integers.
    // We will say that the array 'A' is a 'perfect array' if the following conditions are satisfied:
    //
    // Consider an index 'i' of the array 'A':
    // - The elements present at index '2 * i + 1' (if it exists) and index '2 * i + 2' (if it exists)
    //   perfectly divide the element present at index 'i'.
    // - If all the indices in the array 'A' are 'perfect index', then the array is 'perfect array'.
    // Your task is to return '1' if the array is 'perfect array'. Otherwise, return 0.

    // Sample Test Cases:
    // Test Case 1:
    // Input:
    // 1
    // 6
    // 11 17 12 3 4 3
    // Output:
    // 0
    // Explanation: Index 0 is not a perfect index because 17 does not perfectly divide 11.
    //
    // Test Case 2:
    // Input:
    // 1
    // 6
    // 18 9 6 3 2 3
    // Output:
    // 1
    // Explanation: All indices are perfect indices.
    //
    // Test Case 3:
    // Input:
    // 1
    // 5
    // 4 2 2 1 1
    // Output:
    // 1
    // Explanation: All indices satisfy the perfect index conditions.

    static int perfectArray(int n, int[] a) {
        // Check for perfect index conditions for each index i
        for (int i = 0; i < n; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            // Check divisibility conditions
            if ((leftChildIndex < n && a[i] % a[leftChildIndex] != 0) ||
                    (rightChildIndex < n && a[i] % a[rightChildIndex] != 0)) {
                return 0; // Not a perfect array
            }
        }
        return 1; // It is a perfect array
    }

    public static void main(String[] args) {
        // Running the sample test cases
        int[][] testCases = {
                {6, 11, 17, 12, 3, 4, 3},  // Should return 0
                {6, 18, 9, 6, 3, 2},       // Should return 1
                {5, 4, 2, 2, 1, 1}         // Should return 1
        };


        for (int[] testCase : testCases) {
            int n = testCase[0]; // First element is the size of the array
            int[] A = new int[n];

            // Copy elements manually from testCase to A
            for (int i = 0; i < n; i++) {
                A[i] = testCase[i];
            }

            // Print the result
            System.out.println(perfectArray(n, A));
        }
    }
}
