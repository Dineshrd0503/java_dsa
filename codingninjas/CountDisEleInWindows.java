package codingninjas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//Problem statement
//Given an array of integers ‘arr’ of size ‘n’ and an integer ‘k’. You need to find the count of distinct elements in every sub-array of size ‘k’ in the given array. Return an integer array ‘count’ that consists of n - k + 1 integers where ‘count[i]’ is equal to the number of distinct elements in a sub-array of size ‘k’ starting from index ‘i’.
//
//Note:
//        1. The sub-array of an array is a continuous part of the array.
//2. Consider ‘0’ based indexing.
//        3. ‘k’ will always be less than or equal to ‘n’.
//        3. Don’t print anything, just return the integer array ‘count’.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 50
//        1 <= n <= 10^4
//        1 <= k <= n
//-10^9 <= arr[i] <= 10^9
//
//Where ‘T’ is the total number of test cases, ‘n’ is the given positive integer, ‘k’ is the size of sub-array to be considered, and arr[i] is the value of the array elements.
//
//
//Time limit: 1 sec
//Sample Input 1:
//        2
//        4 3
//        2 2 1 3
//        1 1
//        5
//Sample Output 1:
//        2 3
//        1
//Explanation of Sample Input 1:
//Test case 1:
//Here, ‘n’ = 4, ‘k’ = 3 and ‘arr’ = {2, 2, 1, 3};
//The sub-array of size 3 starting from index 0 is {2, 2, 1} and there are 2 distinct elements i.e  2 and 1 in it.
//The sub-array of size 3 starting from index 1 is {2, 1, 3} and there are 3 distinct elements i.e 2, 1, and 3 in it.
//So, the ‘count’ array will be {2, 3}.
//
//Test case 2:
//Here, ‘n’ = 1, ‘k’ = 1 and ‘arr’ = {1};
//The sub-array of size 1 starting from index 0 is {5} and there is 1 distinct element i.e 5 in it.
//So, the ‘count’ array will be {1}.
//Sample Input 2:
//        2
//        3 3
//        1 1 1
//        3 1
//        1 2 2
//Sample Output 2:
//        1
//        1 1 1
//Explanation of Sample Input 2:
//Test case 1:
//Here, ‘n’ = 3, ‘k’ = 3 and ‘arr’ = {1, 1, 1};
//The sub-array of size 3 starting from index 0 is {1, 1, 1} and there is 1 distinct element i.e 1 in it.
//
//Test case 2:
//Here, ‘n’ = 3, k = ‘1’ and ‘arr’ = {1, 2, 2};
//The sub-array of size 1 starting from index 0 is {1} and there is 1 distinct element i.e 1 in it.
//The sub-array of size 1 starting from index 1 is {2} and there is 1 distinct element i.e 2 in it.
//The sub-array of size 1 starting from index 2 is {2} and there is 1 distinct element i.e 2 in it.
//So, the ‘count’ array will be {1, 1, 1}.

public class CountDisEleInWindows {
    public static ArrayList<Integer> countDistinct(ArrayList<Integer> arr, int n, int k)
    {
        // Write your code here
        ArrayList<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        k--;
        for(int i=0;i<arr.size();i++){
            map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
            if(i<k)
                continue;
            list.add(map.size());
            if(map.get(arr.get(i-k))==1)
                map.remove(arr.get(i-k));
            else
                map.put(arr.get(i-k),map.get(arr.get(i-k))-1);
        }
        return list;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 2, 3));
        int n=7;
        int k=4;
        ArrayList<Integer> result=countDistinct(arr,n,k);
        for(int res:result){
            System.out.print(res+" ");
        }
    }
}
