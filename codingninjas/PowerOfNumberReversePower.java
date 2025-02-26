package codingninjas;

public class PowerOfNumberReversePower {
    static final int MOD = 1000000007;

    public static int power(int N, int R) {
        return modularExponentiation(N, R, MOD);
    }

    // Function to calculate (base^exp) % mod using iterative binary exponentiation
    private static int modularExponentiation(int base, int exp, int mod) {
        long result = 1;
        long x = base % mod;  // To handle large base

        while (exp > 0) {
            if ((exp & 1) == 1) {  // If exponent is odd, multiply the base with result
                result = (result * x) % mod;
            }
            x = (x * x) % mod;  // Square the base
            exp >>= 1;  // Reduce exponent by half
        }

        return (int) result;
    }

    // Function to reverse a number
    public static int reverseNumber(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int N = 2;
        int R = 3;
        System.out.println(power(N, reverseNumber(R)));  // 8
    }
}
