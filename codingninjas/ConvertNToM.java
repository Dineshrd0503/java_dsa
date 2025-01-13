package codingninjas;
//You are given two integers, ‘N’ and ‘M’. You are supposed to perform the following operation to convert ‘N’ to ‘M’.
//
//In one operation, you can:
//
//        1. Choose any bit in ‘N’.
//
//        2. Flip the chosen bit, i.e., if the bit is ‘0’, make it ‘1’ and vice versa.
//
//You are supposed to find the minimum number of operations needed to convert ‘N’ to ‘M’.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1<= T <= 10^4
//        0 <= N, M <= 10^9
//
//Where ’T’ is the number of test cases and ‘N’,’M’ are the given integers.
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        15 2
//        30 0
//Sample Output 1:
//        3
//        4
//Explanation for Sample Input 1:
//In the first test case, the binary representation of ‘15’ is 1111, and the binary representation of ‘2’ is 0010, ie.
//1111
//        0010
//We can flip the third, first, and a fourth bit of 2 to convert 2 to 15. Hence, the answer is 3.
//
//In the second test case, the binary representation of ‘30’ is 11110, and the binary representation of ‘0’ is 00000, ie.
//11110
//        00000
//We can flip the fourth, third, second, fifth bit of 0 to convert 0 to 30.
//Sample Input 2:
//        2
//        10 1
//        4 2
//Sample Output 2:
//        3
//        2

//XOR Operation:

//A useful way to determine which bits differ between two integers is to use the XOR operation (^).
//N ^ M will yield a number whose binary representation has 1s at positions where the bits of N and M differ and 0s where they are the same.
//Counting 1s in Result:
//
//The number of 1s in the result of N ^ M indicates how many bits must be flipped to convert N into M.
//Steps to Solve the Problem
//Read:
//
//Get the number of test cases T.
//For each test case, read the integers N and M.
//Apply XOR:
//
//Compute N ^ M for each test case to identify differing bits.
//Count the Number of 1s:
//
//Count how many bits are set to 1 in the result of the XOR operation. This can be done using the Integer.bitCount() method in Java or a custom method to count bits

public class ConvertNToM {
    public static int conversion(int n, int m) {
        // Write your code here.
        return Integer.bitCount(n^m);
    }
    public static void main(String[] args) {
        int n = 10;
        int m = 20;
        System.out.println(conversion(n, m));
    }
}
