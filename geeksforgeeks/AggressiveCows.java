package geeksforgeeks;

import java.util.Arrays;

//You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.
//
//        Examples :
//
//Input: stalls[] = [1, 2, 4, 8, 9], k = 3
//Output: 3
//Explanation: The first cow can be placed at stalls[0],
//the second cow can be placed at stalls[2] and
//the third cow can be placed at stalls[3].
//The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
//        Input: stalls[] = [10, 1, 2, 7, 5], k = 3
//Output: 4
//Explanation: The first cow can be placed at stalls[0],
//the second cow can be placed at stalls[1] and
//the third cow can be placed at stalls[4].
//The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.
//        Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
//Output: 1
//Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
//The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.
public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n=stalls.length;

        int high=stalls[n-1]-stalls[0];
        int low=1,result=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canplace(stalls,k,mid)){
                result=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return result;


        // code here
    }
    public static boolean canplace(int[] stalls,int k,int distance){
        int count=1,lastpos=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastpos>=distance){
                count++;
                lastpos=stalls[i];
                if(count>=k)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int stalls[] = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println("The minimum number of cows to be placed is: " + aggressiveCows(stalls, k));
    }
}
