package heap;
import java.util.*;
import java.io.*; 

public class MagicianAndChocolates {
    /**
     * In a magic event, you are given ‘N’ bags, each bag containing ‘A[i]’ chocolates.
     * In one unit of time, you can choose any bag ‘i’ and eat all the chocolates ‘A[i]’
     * in that bag and then the magician fills the ith bag with floor(‘A[i]’ / 2) chocolates.
     * Your task is to find the maximum number of chocolate you can eat in ‘K’ units of time.
     *
     * Since the answer could be large, return answer modulo 10^9 + 7.
     *
     * For Example:
     *
     * For the array [ 4, 7, 9, 10] and ‘k’=2
     * In the first step, we can choose the last bag. So the answer will be 10 and the array will be [4, 7, 9, 5].
     * In the second step, we can choose the second last bag. So the answer will be 19 and the array will be [4, 7, 4, 5].
     * So the final output will be 19.
     *
     * Input Format:
     *
     * The first line contains a single integer ‘T’ denoting the number of test cases to be run. Then the test cases follow.
     *
     * The first line of each test case contains two space-separated integers ‘N’ and ‘K’, representing the number of bags and the amount of time.
     *
     * The second line of each test case contains ‘N’ space-separated integers representing the number of chocolates in each bag.
     *
     *
     * Output Format:
     *
     * For each test case, print an integer representing the maximum number of chocolates you can eat in the given amount of time.
     *
     * Output for each test case will be printed in a separate line.
     *
     *
     * Note
     *
     * You are not required to print anything, it has already been taken care of. Just implement the function.
     *
     *
     * Constraints:
     *
     * 1 <= T <= 100
     * 1 <= N <= 10^5
     * 1 <= ARR[i] <= 10^5
     *
     * It is guaranteed that the sum of ‘N’ over all test cases doesn’t exceed 10^5.
     *
     * Time Limit: 1 sec.
     *
     *
     * Sample Input 1:
     *
     * 2
     * 4 1
     * 3 8 2 4
     * 4 2
     * 10 4 7 22
     *
     *
     * Sample Output 1:
     *
     * 8
     * 33
     *
     *
     * Explanation For Sample Output 1:
     *
     * For the first test case,
     * In the first step, we can choose the second bag. So the answer will be 8 and the array will be [3, 4, 2, 4].
     * So, the final answer will be 8.
     *
     * For the second test case,
     * In the first step, we can choose the last bag. So the answer will be 22 and the array will be [10, 4, 7, 11].
     * In the second step, we can choose the last bag. So the answer will be 33 and the array will be [10, 4, 7, 5].
     * So, the final answer will be 33.
     *
     *
     * Sample Input 2:
     *
     * 2
     * 5 3
     * 3 6 10 12 8
     * 4 1
     * 2 10 4 3
     *
     *
     * Sample Output 2:
     *
     * 30
     * 10
     *
     * @param arr An ArrayList of integers representing the number of chocolates in each bag.
     * @param k The amount of time.
     * @return An integer representing the maximum number of chocolates you can eat in the given amount of time.
     */
    public static int maximumChocolates(ArrayList<Integer> arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : arr) queue.add(n);
        long total = 0; // Use long to avoid potential overflow until the modulo operation
        for (int i = 0; i < k; i++) {
            int max = queue.poll();
            total = (total + max) % 1000000007;
            queue.add(max / 2);
        }
        return (int) total; // Cast back to int for the final return
    }

    public static void main(String[] args) {
        // Sample test cases
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(3, 8, 2, 4));
        int k1 = 1;
        System.out.println("Test Case 1: "+maximumChocolates(arr1, k1)); // Expected Output: 8

        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(10, 4, 7, 22));
        int k2 = 2;
        System.out.println("Test Case 2: "+maximumChocolates(arr2, k2)); // Expected Output: 33

        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(3, 6, 10, 12, 8));
        int k3 = 3;
        System.out.println("Test Case 3: "+maximumChocolates(arr3, k3)); // Expected Output: 30

        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(2, 10, 4, 3));
        int k4 = 1;
        System.out.println("Test Case 4: "+maximumChocolates(arr4, k4)); // Expected Output: 10
    }
}
