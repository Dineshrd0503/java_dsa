package arrays;

import java.util.*;

/**
 * Problem Statement:
 * ------------------------
 * Given an integer N, print all numbers strictly less than N that are made
 * using only the digits 2 and 5 (i.e., each digit is either 2 or 5).
 *
 * Example:
 * Input: 30
 * Output: 2 5 22 25
 *
 * Constraints:
 * 1 <= N <= 10^16
 * Time Limit: 1 sec
 *
 * You do not need to print, but return the result as an ArrayList<Long>.
 */

public class CreateSequence {
    /**
     * Generates all numbers less than n using only digits 2 and 5.
     * @param n Upper limit (exclusive).
     * @return List of numbers < n, made only of digits {2,5}, in ascending order.
     */
    public static ArrayList<Long> createSequence(long n) {
        ArrayList<Long> result = new ArrayList<>();
        Queue<Long> queue = new LinkedList<>();

        // Start with single-digit numbers 2 and 5 if less than n
        if (2 < n) queue.add(2L);
        if (5 < n) queue.add(5L);

        // BFS to build numbers
        while (!queue.isEmpty()) {
            long curr = queue.poll();
            result.add(curr);

            long next2 = curr * 10 + 2;
            if (next2 < n) queue.add(next2);

            long next5 = curr * 10 + 5;
            if (next5 < n) queue.add(next5);
        }
        // No need to sort, BFS ensures ascending order
        return result;
    }

    // --- Demo/Test Code: You can run this to check outputs ---
    public static void main(String[] args) {
        long[] testNs = {10, 100, 2, 7};

        for(long N : testNs) {
            System.out.println("Numbers less than " + N + " with digits only 2 and 5:");
            ArrayList<Long> seq = createSequence(N);
            for(Long x : seq) System.out.print(x + " ");
            System.out.println("\n---");
        }
    }
}
