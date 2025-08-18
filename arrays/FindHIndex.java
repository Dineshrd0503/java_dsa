package arrays;

import java.util.Arrays;

public class FindHIndex {

    /*
     * ====================================================================
     * Problem Statement: H-Index
     * ====================================================================
     *
     * Given an array of integers `citations` where `citations[i]` is the
     * number of citations a researcher received for their ith paper,
     * return the researcher's h-index.
     *
     * According to the definition of h-index on Wikipedia: "A scientist
     * has index h if h of their N papers have at least h citations each,
     * and the other N − h papers have no more than h citations each."
     *
     * In simpler terms, find the largest number `h` such that there are
     * at least `h` papers with `h` or more citations.
     *
     * ====================================================================
     * Sample Test Cases
     * ====================================================================
     *
     * Example 1:
     * Input: citations = [3, 0, 6, 1, 5]
     * Output: 3
     * Explanation: The researcher has 5 papers with citations [3, 0, 6, 1, 5].
     * After sorting: [0, 1, 3, 5, 6].
     * They have 3 papers with at least 3 citations each (3, 5, 6) and the
     * remaining two have no more than 3 citations each (0, 1). Thus, their h-index is 3.
     *
     * Example 2:
     * Input: citations = [1, 3, 1]
     * Output: 1
     * Explanation: The researcher has 3 papers with citations [1, 3, 1].
     * They have 1 paper with at least 1 citation.
     *
     * Example 3:
     * Input: citations = [100]
     * Output: 1
     * Explanation: 1 paper with at least 1 citation.
     *
     * Example 4:
     * Input: citations = [0, 0, 0]
     * Output: 0
     * Explanation: 0 papers with at least 1 citation.
     */

    /**
     * Calculates the h-index of a researcher given an array of citation counts.
     *
     * @param citations An array of integers representing the number of citations for each paper.
     * @return The h-index.
     */
    public static int hIndex(int[] citations) {
        // Step 1: Sort the array in ascending order.
        Arrays.sort(citations);

        int n = citations.length;
        int h = 0;

        // Step 2: Iterate from the end of the sorted array.
        for (int i = n - 1; i >= 0; i--) {
            // The number of papers we've seen so far (from the right) is n - i.
            int papersCount = n - i;

            // Step 3: Check the h-index condition.
            // Is the number of citations for the current paper (citations[i])
            // greater than or equal to the number of papers we have considered so far?
            if (citations[i] >= papersCount) {
                // If yes, this count is a possible h-index.
                h = papersCount;
            } else {
                // If no, we can stop. Since the array is sorted, any further papers
                // to the left will have even fewer citations and will also fail this condition.
                break;
            }
        }
        return h;
    }

    // Main method to test the hIndex function with static inputs.
    public static void main(String[] args) {
        // Test Case 1
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println("Citations: " + Arrays.toString(citations1));
        System.out.println("H-Index: " + hIndex(citations1)); // Expected output: 3
        System.out.println("--------------------");

        // Test Case 2
        int[] citations2 = {1, 3, 1};
        System.out.println("Citations: " + Arrays.toString(citations2));
        System.out.println("H-Index: " + hIndex(citations2)); // Expected output: 1
        System.out.println("--------------------");

        // Test Case 3
        int[] citations3 = {100};
        System.out.println("Citations: " + Arrays.toString(citations3));
        System.out.println("H-Index: " + hIndex(citations3)); // Expected output: 1
        System.out.println("--------------------");

        // Test Case 4
        int[] citations4 = {0, 0, 0};
        System.out.println("Citations: " + Arrays.toString(citations4));
        System.out.println("H-Index: " + hIndex(citations4)); // Expected output: 0
        System.out.println("--------------------");
    }
}

