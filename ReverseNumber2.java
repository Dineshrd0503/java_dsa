public class ReverseNumber2{
    public static int reverse(int n) {
        int r = 0;

        while (n != 0) {
            int a = n % 10;

            // Check for overflow before multiplying r by 10
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && a > 7)) {
                return 0; // Overflow for positive numbers
            }
            if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && a < -8)) {
                return 0; // Overflow for negative numbers
            }

            r = r * 10 + a;
            n = n / 10;
        }

        return r;
    }

    // Main method for testing
    public static void main(String[] args) {

        // Test cases
        int num1 = 1534236469; // Expected output: 0 due to overflow
        int num2 = -123;       // Expected output: -321
        int num3 = 120;        // Expected output: 21
        int num4 = 0;          // Expected output: 0

        System.out.println("Reverse of " + num1 + " is: " + reverse(num1));
        System.out.println("Reverse of " + num2 + " is: " + reverse(num2));
        System.out.println("Reverse of " + num3 + " is: " + reverse(num3));
        System.out.println("Reverse of " + num4 + " is: " + reverse(num4));
    }
}
