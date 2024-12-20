package codingninjas;
//You are given a positive integer ‘N’. Your task is to find the total number of ‘1’ in the binary representation of all the numbers from 1 to N.
//
//Since the count of ‘1’ can be huge, you are required to return it modulo 1e9+7.
//
//Note:
//Do not print anything, just return the number of set bits in the binary representation of all integers between 1 and ‘N’.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 100
//        1 <= N <= 10^9
//
//Time limit: 1 second
//Sample Input 1:
//        2
//        5
//        3
//Sample Output 1:
//        7
//        4
//Explanation For Sample Input 1 :
//In the first test case,
//
//DECIMAL    BINARY      SET BIT COUNT
//1            01                  1
//        2            10                  1
//        3            11                  2
//        4            100                 1
//        5            101                 2
//        1 + 1 + 2 + 1 + 2 = 7
//Answer = 7 % 1000000007 = 7
//
//
//In the second test case,
//
//DECIMAL    BINARY      SET BIT COUNT
//1            01                  1
//        2            10                  1
//        3            11                  2
//        1 + 1 + 2 = 4
//Answer = 4 % 1000000007 = 4
//Sample Input 2:
//        2
//        6
//        10
//Sample Output 2:
//        9
//        17
public class SetBits {
    public static int countSetBits(int n)
    {
        int sum=0;
        for(int i=1;i<=n;i++)
            sum+=Integer.bitCount(i);
        return sum;
        //    Write your code here.
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countSetBits(n));
    }


}
