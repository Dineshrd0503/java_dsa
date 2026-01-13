package greedyalgorithms;

/**
 * ============================================================================
 * PROBLEM: Bus Ticket Change (LeetCode Problem - Lemonade Change)
 * ============================================================================
 *
 * You are given an array arr[] representing passengers in a queue.
 * Each bus ticket costs 5 coins, and arr[i] denotes the note a passenger
 * uses to pay (which can be 5, 10, or 20).
 *
 * You must serve the passengers in the given order and always provide the
 * correct change so that each passenger effectively pays exactly 5 coins.
 *
 * Your task is to determine whether it is possible to serve all passengers
 * in the queue without ever running out of change.
 *
 * CONSTRAINTS:
 * - 1 ≤ arr.size() ≤ 10^5
 * - arr[i] contains only [5, 10, 20]
 *
 * TIME COMPLEXITY: O(n) - Single pass through array
 * SPACE COMPLEXITY: O(1) - Only two variables used
 *
 * ============================================================================
 */

public class BusTicketChange {

    /**
     * Main method to solve Bus Ticket Change problem
     *
     * LOGIC:
     * 1. Track count of 5-coin and 10-coin notes only (20-coins don't help in change)
     * 2. For 5 coins: Just collect it, increment counter
     * 3. For 10 coins: Give back one 5-coin note
     * 4. For 20 coins: Give back either (1×10 + 1×5) or (3×5)
     *    - Prefer (1×10 + 1×5) to preserve more 5-coin notes for future transactions
     *
     * @param arr Array representing passenger payment notes
     * @return true if all passengers can be served without running out of change,
     *         false otherwise
     */
    public boolean canServe(int[] arr) {
        // Count of 5-coin notes we have in change
        int fiveCount = 0;

        // Count of 10-coin notes we have in change
        int tenCount = 0;

        // Process each passenger in order
        for (int coin : arr) {
            if (coin == 5) {
                // Customer pays with 5 coins
                // No change needed, just collect it
                fiveCount++;
            }
            else if (coin == 10) {
                // Customer pays with 10 coins
                // Need to give back 5 coins as change

                if (fiveCount > 0) {
                    // We have 5-coin notes to give as change
                    fiveCount--;
                    tenCount++;
                }
                else {
                    // Not enough 5-coin notes to make change
                    return false;
                }
            }
            else if (coin == 20) {
                // Customer pays with 20 coins
                // Need to give back 15 coins as change

                // GREEDY STRATEGY:
                // Prefer giving 1×10 + 1×5 (saves more 5-coin notes)
                // Otherwise give 3×5

                if (tenCount > 0 && fiveCount > 0) {
                    // Best option: give 1×10 + 1×5
                    tenCount--;
                    fiveCount--;
                }
                else if (fiveCount >= 3) {
                    // Alternative: give 3×5
                    fiveCount -= 3;
                }
                else {
                    // Cannot make change for 20 coins
                    return false;
                }
            }
        }

        // Successfully served all passengers without running out of change
        return true;
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        BusTicketChange solution = new BusTicketChange();

        System.out.println("========== BUS TICKET CHANGE PROBLEM ==========\n");

        // ====== TEST CASE 1 ======
        int[] arr1 = {5, 5, 5, 10, 20};
        boolean result1 = solution.canServe(arr1);
        System.out.println("Test Case 1:");
        System.out.println("Input: " + arrayToString(arr1));
        System.out.println("Output: " + result1);
        System.out.println("Explanation:");
        System.out.println("  Customer 1: Pays 5 coins → fiveCount=1");
        System.out.println("  Customer 2: Pays 5 coins → fiveCount=2");
        System.out.println("  Customer 3: Pays 5 coins → fiveCount=3");
        System.out.println("  Customer 4: Pays 10 coins → Give 5 back → fiveCount=2, tenCount=1");
        System.out.println("  Customer 5: Pays 20 coins → Give 10+5 back → fiveCount=1, tenCount=0");
        System.out.println("  Result: Successfully served all passengers\n");

        // ====== TEST CASE 2 ======
        int[] arr2 = {5, 5, 10, 10, 20};
        boolean result2 = solution.canServe(arr2);
        System.out.println("Test Case 2:");
        System.out.println("Input: " + arrayToString(arr2));
        System.out.println("Output: " + result2);
        System.out.println("Explanation:");
        System.out.println("  Customer 1: Pays 5 coins → fiveCount=1");
        System.out.println("  Customer 2: Pays 5 coins → fiveCount=2");
        System.out.println("  Customer 3: Pays 10 coins → Give 5 back → fiveCount=1, tenCount=1");
        System.out.println("  Customer 4: Pays 10 coins → Give 5 back → fiveCount=0, tenCount=2");
        System.out.println("  Customer 5: Pays 20 coins → Cannot make change (need 15, have only 20s)");
        System.out.println("  Result: Cannot serve all passengers\n");

        // ====== TEST CASE 3 ======
        int[] arr3 = {5, 5, 5, 5, 20};
        boolean result3 = solution.canServe(arr3);
        System.out.println("Test Case 3:");
        System.out.println("Input: " + arrayToString(arr3));
        System.out.println("Output: " + result3);
        System.out.println("Explanation:");
        System.out.println("  Customer 1: Pays 5 coins → fiveCount=1");
        System.out.println("  Customer 2: Pays 5 coins → fiveCount=2");
        System.out.println("  Customer 3: Pays 5 coins → fiveCount=3");
        System.out.println("  Customer 4: Pays 5 coins → fiveCount=4");
        System.out.println("  Customer 5: Pays 20 coins → Give 3×5 back → fiveCount=1");
        System.out.println("  Result: Successfully served all passengers\n");

        // ====== TEST CASE 4 ======
        int[] arr4 = {5, 5, 10, 20};
        boolean result4 = solution.canServe(arr4);
        System.out.println("Test Case 4:");
        System.out.println("Input: " + arrayToString(arr4));
        System.out.println("Output: " + result4);
        System.out.println("Explanation:");
        System.out.println("  Customer 1: Pays 5 coins → fiveCount=1");
        System.out.println("  Customer 2: Pays 5 coins → fiveCount=2");
        System.out.println("  Customer 3: Pays 10 coins → Give 5 back → fiveCount=1, tenCount=1");
        System.out.println("  Customer 4: Pays 20 coins → Give 10+5 back → fiveCount=0, tenCount=0");
        System.out.println("  Result: Successfully served all passengers\n");

        // ====== TEST CASE 5 (EDGE CASE) ======
        int[] arr5 = {5};
        boolean result5 = solution.canServe(arr5);
        System.out.println("Test Case 5 (Edge Case):");
        System.out.println("Input: " + arrayToString(arr5));
        System.out.println("Output: " + result5);
        System.out.println("Explanation: Only one customer paying exact amount → Success\n");

        // ====== TEST CASE 6 (EDGE CASE - FAILURE) ======
        int[] arr6 = {5, 20};
        boolean result6 = solution.canServe(arr6);
        System.out.println("Test Case 6 (Edge Case - Failure):");
        System.out.println("Input: " + arrayToString(arr6));
        System.out.println("Output: " + result6);
        System.out.println("Explanation: Cannot make change for 20 when only 5 is available\n");

        System.out.println("========== END OF TEST CASES ==========");
    }

    /**
     * Utility method to convert array to string for printing
     */
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
