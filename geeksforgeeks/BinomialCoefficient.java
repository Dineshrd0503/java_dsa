package geeksforgeeks;

// Problem Description:
// Given two integer values n and r, the task is to find the value of Binomial Coefficient nCr.
// A binomial coefficient nCr can be defined as the coefficient of xr in the expansion of (1 + x)^n
// that gives the number of ways to choose r objects from a set of n objects without considering the order.
// The binomial coefficient nCr is calculated as: C(n,r) = n! / (r! * (n-r)!)
// Note: If r is greater than n, return 0.
// It is guaranteed that the value of nCr will fit within a 32-bit integer.

// Constraints:
// 1 ≤ n ≤ 100
// 1 ≤ r ≤ 100

// Test Cases:
// 1. n = 5, r = 2 → Output: 10 (5! / (3! * 2!) = 10)
// 2. n = 2, r = 4 → Output: 0 (since r > n)
// 3. n = 5, r = 0 → Output: 1 (5! / (5! * 0!) = 1)

public class BinomialCoefficient {
    // Function to calculate nCr
    public int nCr(int n, int r) {
        // Check if r is bigger than n
        if (r > n) {
            return 0;
        }
        // Check if r is 0
        if (r == 0) {
            return 1;
        }

        // To make calculation easier, use smaller value of r or (n-r)
        if (r > n - r) {
            r = n - r;
        }

        // Start with result as 1
        long result = 1;

        // Calculate nCr by multiplying and dividing step by step
        // Like: (n * (n-1) * ... * (n-r+1)) / (1 * 2 * ... * r)
        for (int i = 0; i < r; i++) {
            // Multiply by (n-i)
            result = result * (n - i);
            // Divide by (i+1)
            result = result / (i + 1);
        }

        // Return the final answer
        return (int) result;
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Create an object of the class
        BinomialCoefficient obj = new BinomialCoefficient();

        // Test Case 1: n = 5, r = 2
        int test1 = obj.nCr(5, 2);
        System.out.println("Test 1: n = 5, r = 2, Output = " + test1);

        // Test Case 2: n = 2, r = 4
        int test2 = obj.nCr(2, 4);
        System.out.println("Test 2: n = 2, r = 4, Output = " + test2);

        // Test Case 3: n = 5, r = 0
        int test3 = obj.nCr(5, 0);
        System.out.println("Test 3: n = 5, r = 0, Output = " + test3);
    }
}