package unstop30days;
/**
 * Problem Statement:
 * Given a number N, your task is to calculate the N-th term of Alice's sequence.
 * Alice's sequence consists of the squares of prime numbers:
 * 2^2, 3^2, 5^2, 7^2, 11^2, 13^2, 17^2, 19^2, 23^2, 29^2,……
 *
 * Input Format:
 * - The first line contains a single integer N (1 ≤ N ≤ 10^3).
 *
 * Output Format:
 * - Output the square of the prime number at the N-th position in Alice's sequence.
 *
 * Example Input/Output:
 * Input:
 * 5
 * Output:
 * 121
 * Explanation:
 * The first five prime numbers are: [2, 3, 5, 7, 11]
 * Their squares are: [4, 9, 25, 49, 121]
 * The fifth term is 121.
 */

import java.util.Scanner;

public class NthTermOfPrimeSquares {

    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input N
        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();

        // Validate input
        if (N < 1 || N > 1000) {
            System.out.println("Invalid input. Please enter a number between 1 and 1000.");
            return;
        }

        int count = 0; // To track the number of primes found
        int num = 2;   // Start checking for primes from the smallest prime number
        int nthPrimeSquare = -1; // Store the square of the N-th prime

        // Find the N-th prime number and calculate its square
        while (count < N) {
            if (isPrime(num)) {
                count++; // Increment count when a prime is found
                if (count == N) {
                    nthPrimeSquare = num * num; // Calculate square of the N-th prime
                }
            }
            num++; // Check next number
        }

        // Output the result
        System.out.println("The " + N + "-th term in Alice's sequence is: " + nthPrimeSquare);

        scanner.close();
    }
}
