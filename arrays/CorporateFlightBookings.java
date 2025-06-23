package arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Problem: Corporate Flight Bookings (LeetCode 1109)
 * Given a list of flight bookings and the number of flights, compute the total
 * number of seats reserved for each flight from 1 to n.
 *
 * Input:
 * - T: Number of test cases (hardcoded as 3)
 * - For each test case:
 *   - bookings: ArrayList of bookings, each as [first, last, seats], where seats
 *               are reserved for flights first to last (inclusive, 1-based)
 *   - n: Number of flights
 *
 * Output:
 * - For each test case, an ArrayList<Integer> where answer[i] is the total seats
 *   for flight i+1
 *
 * Example:
 * Test Case 1: bookings = [[1, 2, 10], [2, 3, 20], [2, 5, 25]], n = 5
 * Output: [10, 55, 45, 25, 25]
 * Test Case 2: bookings = [[1, 2, 10], [2, 2, 15]], n = 2
 * Output: [10, 25]
 * Test Case 3: bookings = [[1, 1, 5]], n = 1
 * Output: [5]
 *
 * Constraints:
 * - 1 <= T <= 10^5
 * - 1 <= n <= 2 * 10^4
 * - 1 <= bookings.length <= 2 * 10^4
 * - 1 <= first <= last <= n
 * - 1 <= seats <= 10^4
 * - Time Limit: 1 sec
 *
 * LeetCode Link: https://leetcode.com/problems/corporate-flight-bookings/
 */
public class CorporateFlightBookings {
    /*
     * Computes total seats reserved for each flight using difference array.
     * @param bookings List of bookings as [first, last, seats]
     * @param n Number of flights
     * @return ArrayList of total seats per flight
     */
    public static ArrayList<Integer> corpFlightBookings(ArrayList<ArrayList<Integer>> bookings, int n) {
        ArrayList<Integer> answer = new ArrayList<>(Collections.nCopies(n, 0));

        // Apply difference array technique
        for (ArrayList<Integer> booking : bookings) {
            int first = booking.get(0);
            int last = booking.get(1);
            int seats = booking.get(2);
            answer.set(first - 1, answer.get(first - 1) + seats);
            if (last < n) {
                answer.set(last, answer.get(last) - seats);
            }
        }

        // Compute cumulative sum
        for (int i = 1; i < n; i++) {
            answer.set(i, answer.get(i) + answer.get(i - 1));
        }

        return answer;
    }

    /*
     * Main method with static inputs for test cases.
     */
    public static void main(String[] args) {
        // Define static test cases
        ArrayList<ArrayList<ArrayList<Integer>>> testCases = new ArrayList<>();
        int[] nValues = {5, 2, 1};

        // Test Case 1: bookings = [[1, 2, 10], [2, 3, 20], [2, 5, 25]], n = 5
        ArrayList<ArrayList<Integer>> bookings1 = new ArrayList<>();
        bookings1.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        bookings1.add(new ArrayList<>(Arrays.asList(2, 3, 20)));
        bookings1.add(new ArrayList<>(Arrays.asList(2, 5, 25)));
        testCases.add(bookings1);

        // Test Case 2: bookings = [[1, 2, 10], [2, 2, 15]], n = 2
        ArrayList<ArrayList<Integer>> bookings2 = new ArrayList<>();
        bookings2.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        bookings2.add(new ArrayList<>(Arrays.asList(2, 2, 15)));
        testCases.add(bookings2);

        // Test Case 3: bookings = [[1, 1, 5]], n = 1
        ArrayList<ArrayList<Integer>> bookings3 = new ArrayList<>();
        bookings3.add(new ArrayList<>(Arrays.asList(1, 1, 5)));
        testCases.add(bookings3);

        // Process each test case
        for (int t = 0; t < testCases.size(); t++) {
            ArrayList<Integer> result = corpFlightBookings(testCases.get(t), nValues[t]);
            System.out.println("Test Case " + (t + 1) + ": " + result);
        }
    }
}