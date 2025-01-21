
//Problem statement
//You are given a 32-bit integer ‘N’. Your task is to toggle the rightmost ‘K’ bits in the given integer and return the new integer.
//
//For Example :
//If ‘N’ = 12 and ‘K’ = 2:
//The binary representation of 12 is ‘1100’, after toggling rightmost 2 bits, it becomes ‘1111’ i.e. 15. Hence, the answer is 15.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= N <= 10^9
//        1 <= K <= 31
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        21 3
//        40 4
//Sample Output 1:
//        18
//        39
//Explanation For Sample Input 1:
//In example 1, the binary representation of 21 is '10101'. After toggling rightmost 3 bits, it becomes ‘10010’ which is equal to 18.
//In example 2, the binary representation of 40 is ‘101000’. After toggling rightmost 4 bits, it becomes ‘100111’ which is equal to 39.
//Sample Input 2:
//        2
//        20 2
//        85 5
//Sample Output 2:
//        23
//        74
//Explanation For Sample Input 2:
//In example 1, the binary representation of 20 is '10100'. After toggling rightmost 2 bits, it becomes ‘10111’ which is equal to 23.
//In example 2, the binary representation of 85 is ‘1010101’. After toggling rightmost 5 bits, it becomes ‘1001010’ which is equal to 74.
package codingninjas;

import java.util.*;

public class ToggleKBits {
    public static int toggleKBits(int n, int k) {
        // Create the mask by shifting 1 to the left K times and subtracting 1
        int mask = (1 << k) - 1;
        // Toggle the rightmost K bits of n
        return n ^ mask;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of test cases
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            // Call the function and print the result
            int result = toggleKBits(N, K);
            System.out.println(result);
        }

        scanner.close();
    }
}
