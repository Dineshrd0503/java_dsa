package geeksforgeeks;
//Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct indices such that the sum of there elements is equals to target.
//
//        Examples:
//
//        Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
//        Output: true
//        Explanation: arr[3] + arr[4] = 6 + 10 = 16.
//        Input: arr[] = [1, 2, 4, 3, 6], target = 11
//        Output: false
//        Explanation: None of the pair makes a sum of 11.
//        Constraints:
//        1 ≤ arr.size ≤ 105
import java.util.Map;
import java.util.HashMap;
public class TwoSum {
    boolean twoSum(int arr[], int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            int complement=target-num;
            if(map.containsKey(complement))
                return true;
            map.put(num,1);
            // code here
        }
        return false;
    }
    public static void main(String[] args) {
        TwoSum ts=new TwoSum();
        int arr[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(ts.twoSum(arr, target)); // should return true
    }

}
