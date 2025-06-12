package arrays;

/**
 * Solution to count mega prime numbers in a given range [left, right].
 * A mega prime is a prime number where each digit is also prime (2, 3, 5, 7).
 */
public class MegaPrimeCounter {
    /**
     * Counts mega prime numbers in the range [left, right].
     * @param left Lower bound (inclusive)
     * @param right Upper bound (inclusive)
     * @return Number of mega prime numbers
     */
    public static int countMegaPrimeNumber(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isMegaPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if a number is a mega prime.
     * @param n Number to check
     * @return True if n is a mega prime, false otherwise
     */
    private static boolean isMegaPrime(int n) {
        // Check if n is prime
        if (!isPrime(n)) {
            return false;
        }
        // Check each digit
        while (n > 0) {
            int digit = n % 10;
            if (!isPrime(digit)) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    /**
     * Checks if a number is prime.
     * @param n Number to check
     * @return True if n is prime, false otherwise
     */
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main method to test countMegaPrimeNumber with static inputs.
     */
    public static void main(String[] args) {
        // Test Case 1: left = 1, right = 10
        System.out.println("Test Case 1: " + countMegaPrimeNumber(1, 10) +
                " (Expected: 4)"); // 2, 3, 5, 7

        // Test Case 2: left = 10, right = 20
        System.out.println("Test Case 2: " + countMegaPrimeNumber(10, 20) +
                " (Expected: 0)"); // No mega primes

        // Test Case 3: left = 20, right = 30
        System.out.println("Test Case 3: " + countMegaPrimeNumber(20, 30) +
                " (Expected: 2)"); // 23, 29

        // Test Case 4: left = 1, right = 2
        System.out.println("Test Case 4: " + countMegaPrimeNumber(1, 2) +
                " (Expected: 1)"); // 2

        // Test Case 5: left = 100, right = 100
        System.out.println("Test Case 5: " + countMegaPrimeNumber(100, 100) +
                " (Expected: 0)"); // 100 not prime
    }
}