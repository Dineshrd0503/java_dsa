package greedyalgorithms;

import java.util.Arrays;
import java.util.Scanner;

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
     *
     * Detailed Explanation:
     * Input Format:
     * The first line of the input will contain two integers, 'N' and 'M', denoting the
     * length of the array 'GREED' and 'SIZE'.
     * The second line contains 'N' space-separated integers of the array 'GREED'.
     * The third line contains 'M' space-separated integers of the array 'SIZE'.
     *
     * Output Format:
     * The only line consists of a single integer denoting the maximum number of children
     * whose greed can be satisfied.
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
        Scanner scanner = new Scanner(System.in);

        // Read the number of children (N) and cookies (M)
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // Read the greed values
        int[] greed = new int[N];
        for (int i = 0; i < N; i++) {
            greed[i] = scanner.nextInt();
        }

        // Read the size values
        int[] size = new int[M];
        for (int i = 0; i < M; i++) {
            size[i] = scanner.nextInt();
        }

        // Call the method to determine the maximum number of satisfied children
        int result = assignCookies(greed, size);

        // Output the result
        System.out.println(result);

        scanner.close();
    }
}
