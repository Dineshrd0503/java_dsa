package codingninjas;

import java.util.ArrayList;

//Problem statement
//You are given an arbitrary array ‘arr’ consisting of 'N' non-negative integers. You need to find the sum of bit differences of all the pairs that can be formed in the given array.
//
//In simple words, let us define f(x, y) as the count of different bits at the same position in the binary representations of two integers, x and y.
//
//You need to find the summation of f over all possible values of x and y in the input array I.e sum( f(arr[i], arr[j])) for all 0 <= i < N and 0 <= j < N.
//
//For Example :
//f(2, 3) = 1, as 2 → 0010 and 3 → 0011, only the last bit is different in both the numbers, hence f(2, 3) is 1.
//Note :
//As the final answer may be very large, return your answer modulo 10^9 + 7.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 100
//        1 <= N <= 10^4
//        0 <= arr[i] < 10^9
//
//Time Limit: 1sec
//Sample Input 1 :
//        2
//        2
//        1 2
//        2
//        6 6
//Sample Output 1 :
//        4
//        0
//Explanation for Sample Input 1 :
//Test Case 1:
//All the possible pairs in the given array are:-
//f(1, 1) - as both numbers are same, no. of bit differences is 0
//f(1, 2) - 1 in binary is (0001) and 2 in binary is (0010). There are 2 bits which are different in both the numbers. Hence, no. of bit differences is 2.
//f(2, 2) - as both numbers are the same, no, of bit differences is 0
//f(2, 1) - same as (1, 2), hence no. of bit differences is 2.
//Summing the above values (0+2+0+2) we get 4. Hence, the output is 4.
//
//Test Case 2:
//There is only one possible pair (6,6). As both the numbers are sum, the output is 0.
//Sample Input 2 :
//        2
//        3
//        1 3 5
//        4
//        4 6 7 8
//Sample Output 2 :
//        8
//        26


public class DifferentBitsSumPairWise {
    public static int differentBitsSumPairwise(ArrayList<Integer> arr, int n)
    {
        final int mod=1000000007;
        long total=0;
        for(int bit=0;bit<32;bit++){
            int count=0;
            for(int num:arr){
                if((num&(1<<bit))!=0){
                    count++;
                }
            }
            total+=2L*count*(n-count);
            total%=mod;
        }
        return (int)total;
        // Write Your Code Here.
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        System.out.println(differentBitsSumPairwise(arr,3));
    }
}
