package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array arr[] of integers and another integer target. Find all unique quadruples from the given array that sums up to target.
//
//        Note: All the quadruples should be internally sorted, ie for any quadruple [q1, q2, q3, q4] it should be : q1 <= q2 <= q3 <= q4.
//
//        Examples :
//
//Input: arr[] = [0, 0, 2, 1, 1], target = 3
//Output: [0, 0, 1, 2]
//Explanation: Sum of 0, 0, 1, 2 is equal to 3.
//Input: arr[] = [10, 2, 3, 4, 5, 7, 8], target = 23
//Output: [[2, 3, 8, 10], [2, 4, 7, 10], [3, 5, 7, 8]]
//Explanation: Sum of 2, 3, 8, 10 is 23, sum of 2, 4, 7, 10 is 23 and sum of 3, 5, 7, 8 is also 23.
//Input: arr[] = [0, 0, 2, 1, 1], target = 2
//Output: [0, 0, 1, 1]
//Explanation: Sum of 0, 0, 1, 2 is equal to 2.
//Constraints:
//        1 <= arr.size() <= 200
//        -106 <= target <= 106
//        -106 <= arr[i] <= 106

public class FourSum {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        // code here
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right]; // Use long to prevent overflow

                    if (sum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;

                        // Skip duplicates for the third number
                        while (left < right && arr[left] == arr[left - 1]) left++;
                        // Skip duplicates for the fourth number
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        int arr[] = {1, 0, -1, 0, -2, 2};
        int target = 0;
        FourSum obj = new FourSum();
        System.out.println(obj.fourSum(arr, target));
    }

}
