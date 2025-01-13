package geeksforgeeks;

import java.util.Arrays;

//Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target.
//
//        Examples:
//
//Input: arr[] = [7, 2, 5, 3], target = 8
//Output: 2
//Explanation: There are 2 pairs with sum less than 8: (2, 5) and (2, 3).
//Input: arr[] = [5, 2, 3, 2, 4, 1], target = 5
//Output: 4
//Explanation: There are 4 pairs whose sum is less than 5: (2, 2), (2, 1), (3, 1) and (2, 1).
//Input: arr[] = [2, 1, 8, 3, 4, 7, 6, 5], target = 7
//Output: 6
//Explanation: There are 6 pairs whose sum is less than 7: (2, 1), (2, 3), (2, 4), (1, 3), (1, 4) and (1, 5).
public class PairsWithLessSum {
    static int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int left=0,right=arr.length-1;
        int count=0;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum<target){
                count+=(right-left);
                left++;
            }
            else
                right--;
        }
        return count;
        // Your code here
    }
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 9, 11, 15};
        int target = 10;
        System.out.println("Count of pairs is " + countPairs(arr, target));
    }
}
