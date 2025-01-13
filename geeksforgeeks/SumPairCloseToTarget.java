package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
//        Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.
//
//        Examples:
//
//Input: arr[] = [10, 30, 20, 5], target = 25
//Output: [5, 20]
//Explanation: As 5 + 20 = 25 is closest to 25.
//Input: arr[] = [5, 2, 7, 1, 4], target = 10
//Output: [2, 7]
//Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target.
//Input: arr[] = [10], target = 10
//Output: []
//Explanation: As the input array has only 1 element, return an empty array.
public class SumPairCloseToTarget {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        List<Integer> result=new ArrayList();
        int left=0,right=arr.length-1,currclose=Integer.MAX_VALUE;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(Math.abs(sum-target)<currclose){
                currclose=Math.abs(target-sum);
                result.clear();
                result.add(arr[left]);
                result.add(arr[right]);

            }
            else if(sum<target)
                left++;
            else
                right--;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 9;
        SumPairCloseToTarget obj = new SumPairCloseToTarget();
        System.out.println(obj.sumClosest(arr, target));
    }

}
