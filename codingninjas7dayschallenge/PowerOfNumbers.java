// PowerOfNumbers.java
public class PowerOfNumbers {
    
    /**
     * Problem Statement:
     * You are given a number 'N' and its reverse 'R'.
     * Return the number raised to the power of its own reverse.
     * As answers can be very large, print the result modulo '10^9 + 7'.
     * 
     * Sample Input 1:
     * 14 41
     * Sample Output 1:
     * 722400406
     * 
     * Sample Input 2:
     * 2 2
     * Sample Output 2:
     * 4
     * 
     * Constraints:
     * 1 <= N <= 10^9
     * Time Limit: 1 sec
     */
    
    public static int power(int n, int r) {
        long result = 1;
        int mod = 1000000007;
        long base = n % mod;

        while (r > 0) {
            if (r % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            r /= 2;
        }
        
        return (int) result;
    }

    public static void main(String[] args) {
        // Test cases
        int n1 = 14, r1 = 41;
        System.out.println("Input: " + n1 + " " + r1);
        System.out.println("Output: " + power(n1, r1)); // Expected: 722400406

        int n2 = 2, r2 = 2;
        System.out.println("Input: " + n2 + " " + r2);
        System.out.println("Output: " + power(n2, r2)); // Expected: 4
        
        // Additional test case
        int n3 = 20, r3 = 2;
        System.out.println("Input: " + n3 + " " + r3);
        System.out.println("Output: " + power(n3, r3)); // Expected: 400
    }
}
