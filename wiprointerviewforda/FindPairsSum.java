package wiprointerviewforda;
import java.util.*;

public class FindPairsSum {
    // Problem: Find all pairs in an array that sum up to a specific target
    // Sample Test Cases:
    // Input: arr = [1, 5, 7, -1, 5], target = 6
    // Output: Pairs: (1, 5), (-1, 7)
    // Input: arr = [2, 2, 2, 2], target = 4
    // Output: Pairs: (2, 2)
    // Input: arr = [], target = 5
    // Output: No pairs found

    public static List<int[]> findPairs(int[] arr, int target) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Store frequency of each number
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find pairs
        for (int num : arr) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                // Handle case where num == complement (e.g., target=8, num=4)
                if (num == complement && map.get(num) > 1) {
                    result.add(new int[]{num, complement});
                } else if (num != complement && map.containsKey(complement)) {
                    result.add(new int[]{num, complement});
                }
                // Remove used numbers to avoid duplicates
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) map.remove(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 5, 7, -1, 5};
        int target1 = 6;
        System.out.println("Test Case 1:");
        List<int[]> pairs1 = findPairs(arr1, target1);
        if (pairs1.isEmpty()) {
            System.out.println("No pairs found");
        } else {
            System.out.print("Pairs: ");
            for (int[] pair : pairs1) {
                System.out.print("(" + pair[0] + ", " + pair[1] + ") ");
            }
            System.out.println();
        }

        // Test Case 2
        int[] arr2 = {2, 2, 2, 2};
        int target2 = 4;
        System.out.println("\nTest Case 2:");
        List<int[]> pairs2 = findPairs(arr2, target2);
        if (pairs2.isEmpty()) {
            System.out.println("No pairs found");
        } else {
            System.out.print("Pairs: ");
            for (int[] pair : pairs2) {
                System.out.print("(" + pair[0] + ", " + pair[1] + ") ");
            }
            System.out.println();
        }

        // Test Case 3
        int[] arr3 = {};
        int target3 = 5;
        System.out.println("\nTest Case 3:");
        List<int[]> pairs3 = findPairs(arr3, target3);
        if (pairs3.isEmpty()) {
            System.out.println("No pairs found");
        } else {
            System.out.print("Pairs: ");
            for (int[] pair : pairs3) {
                System.out.print("(" + pair[0] + ", " + pair[1] + ") ");
            }
            System.out.println();
        }
    }
}