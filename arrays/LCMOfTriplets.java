package arrays;

// Given a number n. Find the maximum possible LCM that can be obtained
// by selecting three numbers less than or equal to n.
// Note : LCM stands for Lowest Common Multiple.
//
// Examples:
//
// Input: n = 9
// Output: 504
// Explanation: 504 is the maximum LCM that can be attained by any triplet
// of numbers less than or equal 9. The triplet which has this LCM is {7, 8, 9}.
//
// Input: n = 7
// Output: 210
// Explanation: 210 is the maximum LCM that can be attained by any triplet
// of numbers less than or equal 7. The triplet which has this LCM is {5, 6, 7}.
//
// Constraints:
// 1 <= n <= 10^3

public class LCMOfTriplets {
    /**
     * Calculates the maximum possible LCM of three numbers less than or equal to n.
     *
     * @param n The upper bound for the numbers.
     * @return The maximum possible LCM.
     */
    static long lcmTriplets(int n) {
        if (n <= 2) {
            return n;
        }

        if (n % 2 != 0) {
            return (long) n * (n - 1) * (n - 2); // Cast to long to avoid int overflow
        } else {
            if (n % 3 != 0) {
                return (long) n * (n - 1) * (n - 3); // Cast to long to avoid int overflow
            } else {
                return (long) (n - 1) * (n - 2) * (n - 3); // Cast to long to avoid int overflow
            }
        }
    }

    public static void main(String[] args) {

        //Sample test cases
        int n1 = 9;
        System.out.println("n = " + n1 + ", Max LCM = " + lcmTriplets(n1)); // Output: 504

        int n2 = 7;
        System.out.println("n = " + n2 + ", Max LCM = " + lcmTriplets(n2)); // Output: 210

        int n3 = 5;
        System.out.println("n = " + n3 + ", Max LCM = " + lcmTriplets(n3)); // Output: 60

        int n4 = 6;
        System.out.println("n = " + n4 + ", Max LCM = " + lcmTriplets(n4)); // Output: 60

        int n5 = 4;
        System.out.println("n = " + n5 + ", Max LCM = " + lcmTriplets(n5)); // Output: 12

        int n6 = 1;
        System.out.println("n = " + n6 + ", Max LCM = " + lcmTriplets(n6)); // Output: 1

        int n7 = 2;
        System.out.println("n = " + n7 + ", Max LCM = " + lcmTriplets(n7)); // Output: 2

        int n8 = 3;
        System.out.println("n = " + n8 + ", Max LCM = " + lcmTriplets(n8)); // Output: 6

        int n9 = 10;
        System.out.println("n = " + n9 + ", Max LCM = " + lcmTriplets(n9)); // Output: 720
    }
}