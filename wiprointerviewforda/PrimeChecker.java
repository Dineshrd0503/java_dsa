package wiprointerviewforda;
public class PrimeChecker {
    // Problem: Check if a number is prime
    // Sample Test Cases:
    // Input: n = 17
    // Output: true
    // Input: n = 4
    // Output: false
    // Input: n = 1
    // Output: false

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1
        int n1 = 17;
        System.out.println("Test Case 1:");
        System.out.println(isPrime(n1));

        // Test Case 2
        int n2 = 4;
        System.out.println("\nTest Case 2:");
        System.out.println(isPrime(n2));

        // Test Case 3
        int n3 = 1;
        System.out.println("\nTest Case 3:");
        System.out.println(isPrime(n3));
    }
}