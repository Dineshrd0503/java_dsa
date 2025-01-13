package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//Given an array of integers ‘ARR’ and an integer ‘X’, you are supposed to find the number of subarrays of 'ARR' which have bitwise XOR of the elements equal to 'X'.
//
//Note:
//An array ‘B’ is a subarray of an array ‘A’ if ‘B’ that can be obtained by deletion of, several elements(possibly none) from the start of ‘A’ and several elements(possibly none) from the end of ‘A’.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 10
//        3 <= N <= 5 * 10 ^ 4
//        0 <= X <= 10 ^ 9
//        0 <= ARR[i] <= 10 ^ 9
//
//Where ‘T’ denotes the number of test cases, ‘N’ denotes the number of elements in the array, ‘X’ denotes the required subarray XOR and ARR[i] denotes the 'i-th' element of the given array.
//
//Time Limit: 1 sec
//Sample Input 1 :
//        2
//        5 8
//        5 3 8 3 10
//        3 7
//        5 2 9
//Sample Output 1 :
//        2
//        1
//Explanation of Sample Input 1 :
//In the first test case, the subarray from index 1 to index 3 i.e. {3,8,3} and the subarray from index 2 to index 2 i.e. {8} have bitwise XOR equal to 8.
//
//In the second test case, the subarray from index 0 to index 1 i.e. {5,2} has bitwise XOR equal to 7.
//Sample Input 2 :
//        2
//        6 11
//        10 1 0 3 4 7
//        5 4
//        4 3 1 2 4
//Sample Output 2 :
//        3
//        4
public class SubArraySumXor {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        // Write your code here.
        int xor=0,count=0;
        Map<Integer,Integer> xormap=new HashMap<>();
        xormap.put(0,1);
        for(int i=0;i<arr.size();i++){
            xor^=arr.get(i);
            int k=xor^x;
            if(xormap.containsKey(k))
                count+=xormap.get(k);
            xormap.put(xor,xormap.getOrDefault(xor,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        int x = 0;
        System.out.println(subarraysXor(arr, x)); // Output: 0
    }
}
