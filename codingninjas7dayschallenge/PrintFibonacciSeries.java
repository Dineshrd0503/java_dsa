// Class to print the first n Fibonacci numbers
package codingninjas7dayschallenge;
public class PrintFibonacciSeries {

    /**
     * This method generates the first n Fibonacci numbers.
     *
     * @param n The number of Fibonacci numbers to generate
     * @return An array containing the first n Fibonacci numbers
     */
    public static int[] generateFibonacciNumbers(int n) {
        // Initialize the first two Fibonacci numbers
        int a = 0, b = 1, c;
        // Create an array to hold the Fibonacci numbers
        int[] fib = new int[n];

        // Handle the first Fibonacci number if n > 0
        if (n > 0) {
            fib[0] = a; // First Fibonacci number
        }
        
        // Handle the second Fibonacci number if n > 1
        if (n > 1) {
            fib[1] = b; // Second Fibonacci number
        }

        // Generate the rest of the Fibonacci numbers
        for (int i = 2; i < n; i++) {
            c = a + b; // Calculate the next Fibonacci number
            fib[i] = c; // Store it in the array
            a = b; // Update 'a' to the previous 'b'
            b = c; // Update 'b' to the newly calculated Fibonacci number
        }
        
        return fib; // Return the array of Fibonacci numbers
    }

    public static void main(String[] args) {
        // Example input for testing
        int n1 = 5;
        int[] fibonacciNumbers1 = generateFibonacciNumbers(n1);
        
        System.out.print("First " + n1 + " Fibonacci numbers: ");
        for (int num : fibonacciNumbers1) {
            System.out.print(num + " "); // Print each Fibonacci number
        }
        System.out.println(); // New line for better readability

        // Another example input for testing
        int n2 = 3;
        int[] fibonacciNumbers2 = generateFibonacciNumbers(n2);
        
        System.out.print("First " + n2 + " Fibonacci numbers: ");
        for (int num : fibonacciNumbers2) {
            System.out.print(num + " "); // Print each Fibonacci number
        }
    }
}
