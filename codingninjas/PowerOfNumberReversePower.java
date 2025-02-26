package codingninjas;

//Problem statement
//You are given a number 'N' and its reverse 'R'.
//
//
//
//Return the number raised to the power of its own reverse. As answers can be very large, print the result modulo '10^9 + 7'.
//
//
//
//For Example:
//
//For 'N' = 20, 'R' = 2
//The answer is 400 since 20^2 as the reverse of 20 is 2.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        14 41
//Sample Output 1:
//        722400406
//Explanation of sample output 1:
//        'N' = 14
//Answer is 14^41 as the reverse of 14 is 41.
//when divided by 1000000007 gives remainder as 722400406
//Sample Input 2:
//        2 2
//Sample Output 2:
//        4
//Constraints:
//        1 <= N <= 10^9
//Time Limit: 1 sec




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
