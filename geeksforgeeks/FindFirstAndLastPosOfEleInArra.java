import java.util.ArrayList;

/*
 * Problem: First and Last Occurrences
 *
 * Difficulty: Medium
 * Accuracy: 37.36%
 * Submissions: 278K+
 * Points: 4
 * Average Time: 15m
 *
 * Given a sorted array `arr` with possibly some duplicates, the task is to 
 * find the first and last occurrences of an element `x` in the given array.
 *
 * Note: If the number `x` is not found in the array, then return both the 
 * indices as -1.
 *
 * Examples:
 *
 * Input: arr[] = [1, 3, 5, 5, 5, 5, 67, 123, 125], x = 5
 * Output: [2, 5]
 * Explanation: First occurrence of 5 is at index 2 and last occurrence 
 * of 5 is at index 5
 *
 * Input: arr[] = [1, 3, 5, 5, 5, 5, 7, 123, 125], x = 7
 * Output: [6, 6]
 * Explanation: First and last occurrence of 7 is at index 6
 *
 * Input: arr[] = [1, 2, 3], x = 4
 * Output: [-1, -1]
 * Explanation: No occurrence of 4 in the array, so the output is 
 * [-1, -1]
 *
 * Constraints:
 * 1 ≤ arr.size() ≤ 10^6
 * 1 ≤ arr[i], x ≤ 10^9
 *
 */


public class FindFirstAndLastPosOfEleInArray {
    ArrayList<Integer> find(int arr[], int x) {
        // Create an ArrayList to store the results
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1); // First occurrence
        result.add(-1); // Last occurrence
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                if (result.get(0) == -1)
                    result.set(0, i);
                result.set(1, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindFirstAndLastPosOfEleInArray finder = new FindFirstAndLastPosOfEleInArray();
        int[] arr = {1, 2, 3, 4, 2, 5, 2};
        int x = 2;
        ArrayList<Integer> result = finder.find(arr, x);
        System.out.println("First Occurrence: " + result.get(0));
        System.out.println("Last Occurrence: " + result.get(1));
    }
}
