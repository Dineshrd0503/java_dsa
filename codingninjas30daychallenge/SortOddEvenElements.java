package codingninjas30daychallenge;
import java.util.Arrays;


//You are given a 0-indexed array ‘NUMS’ consisting of ‘N’ integers. Sort the array ‘NUMS’ in such a way that the first half of the array contains only odd numbers sorted in non-increasing order and the second half contains only even numbers sorted in non-decreasing order.
//
//Example:
//Input: ‘N’ = 4,  ‘NUMS’ = [2, 5, 3, 6]
//
//Output: [5, 3, 2, 6]
//
//Sorting the odd numbers of the array ‘NUMS’ in non-increasing order, the result is 5, 3
//Then, Sorting the even numbers in non-decreasing order, the result is 2, 6.
//Since the final array should contain the odd numbers in non-increasing order in the first half and even numbers in non-decreasing order in the other half.
//So, the final array is [5, 3, 2, 6].
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 10
//        1 <= N <= 10^5
//Sum of ‘N’ <= 10^5
//        1 <= NUMS[i] <= 10^9
//
//Time Limit: 1 sec
//Sample Input 1 :
//        2
//        4
//        9 4 2 6
//        2
//        2 1
//Sample Output 1 :
//        9 2 4 6
//        1 2
//Explanation Of Sample Input 1 :
//For the first case:
//Sorting odd integers in non-increasing order we get = 9
//Sorting even integers in non-decreasing order we get = 2 4 6
//So, the final array is [9, 2, 4, 6].
//
//For the second case:
//Sorting odd integers in non-increasing order we get = 1
//Sorting even integers in non-decreasing order we get = 2
//So, the final array is [1, 2].
//Sample Input 2 :
//        2
//        6
//        20 12 1 28 16 20
//        5
//        2 14 29 21 11
//Sample Output 2 :
//        1 12 16 20 20 28
//        29 21 11 2 14


public class SortOddEvenElements {


        public static void sortOddEven(int[] nums) {
            int n = nums.length;

            // Step 1: Partition odd and even numbers
            int oddIndex = 0; // Pointer for odd numbers
            for (int i = 0; i < n; i++) {
                if (nums[i] % 2 != 0) { // If odd
                    // Swap nums[i] with nums[oddIndex]
                    int temp = nums[i];
                    nums[i] = nums[oddIndex];
                    nums[oddIndex] = temp;
                    oddIndex++;
                }
            }

            // Step 2: Sort odd numbers in non-increasing order
            Arrays.sort(nums, 0, oddIndex); // Sort odd part in ascending order
            reverse(nums, 0, oddIndex - 1); // Reverse to get descending order

            // Step 3: Sort even numbers in non-decreasing order
            Arrays.sort(nums, oddIndex, n); // Sort even part in ascending order
        }

        // Helper method to reverse a portion of the array
        private static void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        public static void main(String[] args) {
            // Test Case 1
            int[] nums1 = {9, 4, 2, 6};
            sortOddEven(nums1);
            System.out.println("Output for nums1: " + Arrays.toString(nums1)); // [9, 2, 4, 6]

            // Test Case 2
            int[] nums2 = {20, 12, 1, 28, 16, 20};
            sortOddEven(nums2);
            System.out.println("Output for nums2: " + Arrays.toString(nums2)); // [1, 12, 16, 20, 20, 28]

            // Test Case 3
            int[] nums3 = {29, 21, 11, 2, 14};
            sortOddEven(nums3);
            System.out.println("Output for nums3: " + Arrays.toString(nums3)); // [29, 21, 11, 2, 14]
        }
    }

