package codingninjas6monthschallenge;

import java.util.Arrays;

public class AssignCookies {

    /**
     * Problem Statement:
     * There are 'N' children and 'M' cookies.
     * You are given two arrays, 'SIZE', and 'GREED', where 'GREED[i]' is the greed of the 'i'th child and
     * 'SIZE[j]' is the size of the 'j'th cookie.
     * You must assign 'j'th cookie to 'i'th child such that the greed of maximum children is satisfied.
     * A child's greed is satisfied if the size of the cookie assigned to him is greater than or equal to his greed.
     *
     * You must return the maximum number of children whose greed can be satisfied.
     *
     * Example:
     * Input:
     * GREED = [3, 5, 6, 4], SIZE = [1, 4, 5], N = 4, M = 3
     * Output: 2
     *
     * Explanation: We can assign the second cookie to the fourth child and the third to the second.
     * Hence we return 2.
     */

    public static int assignCookies(int[] greed, int[] size) {
        // Sort both greed and size arrays
        Arrays.sort(greed);
        Arrays.sort(size);

        int childIndex = 0; // Pointer for greed array
        int cookieIndex = 0; // Pointer for size array
        int satisfiedCount = 0; // Count of satisfied children

        // Iterate over both arrays
        while (childIndex < greed.length && cookieIndex < size.length) {
            // If the current cookie can satisfy the current child's greed
            if (size[cookieIndex] >= greed[childIndex]) {
                satisfiedCount++; // One more child can be satisfied
                childIndex++; // Move to the next child
            }
            // Move to the next cookie
            cookieIndex++;
        }

        return satisfiedCount; // Return the count of satisfied children
    }

    public static void main(String[] args) {
        // Static input values
        int[] greed = {3, 5, 6, 4};  // Example GREED input
        int[] size = {1, 4, 5};       // Example SIZE input

        // Call the method to determine the maximum number of satisfied children
        int result = assignCookies(greed, size);

        // Output the result
        System.out.println("Maximum number of children satisfied: " + result);
    }
}