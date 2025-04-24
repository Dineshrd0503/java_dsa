/*
Problem Statement:
You have been given an array/list (ARR) of positive and negative integers. 
Print the number of pairs where:
    arr[i] = -arr[j] and i != j

Note:
- Given array/list can contain duplicate elements and will not contain '0'.
- (arr[i], arr[j]) and (arr[j], arr[i]) are considered the same.

Constraints:
1 <= N <= 10^5
-10^9 <= arr[i] <= 10^9

Sample Input 1:
9
-1 3 6 2 5 -4 3 2 -4
Sample Output 1:
0

Sample Input 2:
6
-2 8 2 5 -2 -5
Sample Output 2:
3
*/
package codingninjas7dayschallenge;
import java.util.*;

public class CountPosNegPairs {

    // Function to count valid (x, -x) pairs
    public static long countPositiveNegativePairs(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;

        // Step 1: Count frequency of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: For each number, check if its negative exists
        Set<Integer> visited = new HashSet<>();
        for (int num : map.keySet()) {
            int opposite = -num;
            if (!visited.contains(num) && map.containsKey(opposite)) {
                count += (long) map.get(num) * map.get(opposite);
                visited.add(num);
                visited.add(opposite);
            }
        }

        return count;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {-1, 3, 6, 2, 5, -4, 3, 2, -4};
        System.out.println("Output 1: " + countPositiveNegativePairs(arr1)); // Expected: 0

        // Test Case 2
        int[] arr2 = {-2, 8, 2, 5, -2, -5};
        System.out.println("Output 2: " + countPositiveNegativePairs(arr2)); // Expected: 3
    }
}
