package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//You are given an integer array 'ARR' of size 'N' and an integer 'S'. Your task is to return the list of all pairs of elements such that each sum of elements of each pair equals 'S'.
//
//Note:
//
//Each pair should be sorted i.e the first value should be less than or equals to the second value.
//
//Return the list of pairs sorted in non-decreasing order of their first value. In case if two pairs have the same first value, the pair with a smaller second value should come first.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= N <= 10^3
//        -10^5 <= ARR[i] <= 10^5
//        -2 * 10^5 <= S <= 2 * 10^5
//
//Time Limit: 1 sec
//Sample Input 1:
//        5 5
//        1 2 3 4 5
//Sample Output 1:
//        1 4
//        2 3
//Explaination For Sample Output 1:
//Here, 1 + 4 = 5
//        2 + 3 = 5
//Hence the output will be, (1,4) , (2,3).
//Sample Input 2:
//        5 0
//        2 -3 3 3 -2
//Sample Output 2:
//        -3 3
//        -3 3
//        -2 2
public class PairSum {

    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> list = new ArrayList<>();

        // Sort the array to efficiently find pairs.
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int sum = arr[left] + arr[right];
            if (sum < s) {
                left++;
            } else if (sum > s) {
                right--;
            } else {
                // Found a valid pair
                // Handle duplicates for left
                int currentLeft = arr[left];
                int leftCount = 0;

                // Count how many times arr[left] appears
                while (left <= right && arr[left] == currentLeft) {
                    leftCount++;
                    left++;
                }

                // Handle duplicates for right
                int currentRight = arr[right];
                int rightCount = 0;

                // Count how many times arr[right] appears
                while (left <= right && arr[right] == currentRight) {
                    rightCount++;
                    right--;
                }

                // Add pairs to the list
                if (currentLeft == currentRight) {
                    // When both numbers are the same
                    for (int i = 0; i < leftCount * (leftCount - 1) / 2; i++) {
                        list.add(new int[]{currentLeft, currentRight});
                    }
                } else {
                    // Add all combinations of counts from left and right
                    for (int i = 0; i < leftCount; i++) {
                        for (int j = 0; j < rightCount; j++) {
                            list.add(new int[]{currentLeft, currentRight});
                        }
                    }
                }
            }
        }

        return list;
        // Write your code here.
    }

    public static void main(String[] args) {
        int n = 5;
        int s = 5;
        int[] arr = {1, 2, 3, 4, 5};
        List<int[]> result = pairSum(arr, s);
        for (int[] pair : result) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }


}

