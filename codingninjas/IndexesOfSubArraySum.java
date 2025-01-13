package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.
//
//Note: If no such array is possible then, return [-1].
//
//Examples:
//
//Input: arr[] = [1, 2, 3, 7, 5], target = 12
//Output: [2, 4]
//Explanation: The sum of elements from 2nd to 4th position is 12.
//Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
//Output: [1, 5]
//Explanation: The sum of elements from 1st to 5th position is 15.
//Input: arr[] = [5, 3, 4], target = 2
//Output: [-1]
//Explanation: There is no subarray with sum 2.
//Constraints:
public class IndexesOfSubArraySum {
        public static ArrayList<Integer> subarraySum(int[] arr, int target) {
            int currSum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1); // To handle the case when subarray starts from index 0

            for (int i = 0; i < arr.length; i++) {
                currSum += arr[i];

                if (map.containsKey(currSum - target)) {
                    return new ArrayList<>(List.of(map.get(currSum - target) + 2, i + 1));
                }

                map.put(currSum, i);
            }

            return new ArrayList<>(List.of(-1));
        }

        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 7, 5};
            int target1 = 12;
            System.out.println(subarraySum(arr1, target1)); // Output: [2, 4]

            int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int target2 = 15;
            System.out.println(subarraySum(arr2, target2)); // Output: [1, 5]

            int[] arr3 = {5, 3, 4};
            int target3 = 2;
            System.out.println(subarraySum(arr3, target3)); // Output: [-1]
        }
    }
