public class BeautifulDays{
    public static int beautifulDays(int i, int j, int k) {
        int count = 0;

        // Loop through each number from i to j
        for (int n = i; n <= j; n++) {
            // Reverse the current number 'n'
            int reversed = reverseNumber(n);

            // Check if the absolute difference between 'n' and its reverse is divisible by 'k'
            if (Math.abs(n - reversed) % k == 0) {
                count++;
            }
        }

        return count; // Return the number of beautiful days
    }

    // Helper function to reverse a number
    public static int reverseNumber(int num) {
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        // Example of how to call the function and test with sample inputs
        int i = 20;  // Start day
        int j = 23;  // End day
        int k = 6;   // Divisor

        // Call the function and print the result
        int result = beautifulDays(i, j, k);
        System.out.println(result);  // Output: 2
    }
}
