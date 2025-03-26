package hackerrank;

public class SuperSum {
        public static int superDigit(String n, int k) {
            // Step 1: Calculate the initial sum of digits in n
            long initialSum = 0;
            for (char digit : n.toCharArray()) {
                initialSum += Character.getNumericValue(digit);
            }

            // Step 2: Multiply the sum by k to account for concatenation
            long totalSum = initialSum * k;

            // Step 3: Calculate the super digit recursively
            return calculateSuperDigit(totalSum);
        }

        private static int calculateSuperDigit(long num) {
            // Base case: if num is a single digit, return it
            if (num < 10) {
                return (int) num;
            }

            // Recursive case: calculate the sum of digits
            long sum = 0;
            while (num > 0) {
                sum += num % 10; // Add last digit to sum
                num /= 10;       // Remove last digit
            }

            // Recur with the new sum
            return calculateSuperDigit(sum);
        }

        public static void main(String[] args) {
            // Example usage
            String n = "9875";
            int k = 4;
            System.out.println(superDigit(n, k)); // Output should be 8
        }

}
