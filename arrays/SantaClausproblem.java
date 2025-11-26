package arrays;

/*
 * PROBLEM STATEMENT:
 * This year Santa Claus got a magic bag for bringing gifts for children.
 * The magic bag refills to its full capacity N whenever the number of gifts becomes strictly less than K.
 * A child can ask for M (M < N) gifts. This reduces the bag count by M.
 * If the demand is more than the current number, print -1 for that demand.
 * Output the number of gifts left in the bag after each valid demand (after refill, if triggered).
 *
 * Sample Input:
 *   N = 10, K = 4, demands = {4, 2, 2}
 * Output:
 *   6
 *   4
 *   10
 */

public class SantaClausproblem {
    public static int[] giftsLeft(int n, int k, int q, int[] demands) {
        int[] result = new int[q];
        int capacity = n; // The current number of gifts in the bag
        for (int i = 0; i < q; i++) {
            if (demands[i] > capacity) {
                result[i] = -1;
            } else {
                capacity -= demands[i];
                if (capacity < k) {
                    capacity = n; // refill happens after this demand is processed
                }
                result[i] = capacity;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example test case 1
        int n = 10;
        int k = 4;
        int[] demands = {4, 2, 2};
        int[] result = giftsLeft(n, k, demands.length, demands);
        System.out.println("Output for Sample Input 1:");
        for (int val : result) {
            System.out.println(val);
        }

        // Example test case 2
        int n2 = 7, k2 = 6;
        int[] demands2 = {3, 8};
        int[] result2 = giftsLeft(n2, k2, demands2.length, demands2);
        System.out.println("Output for Sample Input 2:");
        for (int val : result2) {
            System.out.println(val);
        }
    }
}
