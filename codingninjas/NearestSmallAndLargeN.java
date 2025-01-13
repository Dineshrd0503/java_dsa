package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
//Given a positive integer ‘n’, your task is to find the next smallest integer and the previous largest integer having the exact number of ‘1’ bits set in their binary representation as ‘n’.
//
//Example:
//        ‘n = 6’
//The binary representation of 6 = ‘0110’, which has two ‘1’ bits set.
//Next smallest integer = 9 = ‘1001’, the smallest integer greater than 6 having two ‘1’ bits set.
//Previous largest integer = 5 = ‘0101’, largest integer smaller than 6 having two ‘1’ bits set.
//Therefore, the answer is {9, 5}.
//Note:
//        1. ‘n’ is a positive integer greater than one.
//2. For any given integer ‘n’, there is always a positive integer smaller than ‘n’ having the exact number of ‘1’ bits set.
//        3. Don’t print anything. Just implement the function and return the answer.
//        4. ‘n’ can have a max of ‘30’ bits.
//        Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10000
//        ‘n’ can have ‘30’ bits at max
//
//Where ‘T’ is the number of test cases, and ‘n’ is the given integer.
//
//Time limit: 1 second
//Sample input 1:
//        2
//        6
//        9
//Sample output 1:
//        9 5
//        10 6
//Explanation of sample input 1:
//Test Case 1:
//
//The binary representation of {5 = 0101, 6 = 0110, 7 = 0111, 8 = 1000, 9 = 1001}, here ‘9’ is the smallest integer greater than ‘6’ and ‘5’ is the largest integer smaller than ‘6’ having the exact number of ‘1’ bits set (i.e., two set bits) as that of ‘6’, so the answer is {9, 5}.
//
//
//Test Case 2:
//
//The binary representation of {6 = 0110, 7 = 0111, 8 = 1000, 9 = 1001, 10 = 1010}, here ‘10’ is the smallest integer greater than ‘9’ and ‘6’ is the largest integer smaller than ‘9’ having the exact number of ‘1’ bits set (i.e., two set bits) as that of ‘9’, so the answer is {10, 6}.
//Sample input 2:
//        2
//        4
//        5
//Sample output 2:
//        8 2
//        6 3
public class NearestSmallAndLargeN {
    public static ArrayList<Integer> nearestNumbers(int n) {

        // Write Your Code here
        int ones=Integer.bitCount(n);
        int next=n+1;
        while(Integer.bitCount(next)!=ones)
            next++;
        int prev=n-1;
        while(Integer.bitCount(prev)!=ones)
            prev--;
        return new ArrayList<>(Arrays.asList(next,prev));
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nearestNumbers(n)); // should return [15, 5]
    }
}
