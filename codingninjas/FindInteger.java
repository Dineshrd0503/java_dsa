package codingninjas;

//Problem statement
//You are given two integers, ‘N’ and ‘K’. Assume numbers from 1 to ‘N’ are arranged such that all odd numbers (in ascending order) are present first and then come to all even numbers (also in ascending order).
//
//You need to find the integer at position ‘K’ (numbering of positions starts from 1).
//
//For example:
//You are given ‘N’ as 7 and ‘K’ as 4.  Numbers from 1 to 7 are arranged as [1, 3, 5, 7, 2, 4, 6], and the number at position 4 is 7. So, the answer is 7.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= N <= 10^12
//        1 <= K <= N
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        7 4
//        5 3
//Sample Output 1:
//        7
//        5
//Explanation:
//For the first test case, the numbers from 1 to 7 are arranged as [1, 3, 5, 7, 2, 4, 6], and the number at position 4 is 7. Hence the answer is 7.
//
//For the second test case, the numbers from 1 to 5 are arranged as [1, 3, 5, 2, 4], and the number at position 3 is 5. Hence the answer is 5.
//Sample Input 2:
//        2
//        6 2
//        7 3
//Sample Output 2:
//        3
//        5




public class FindInteger {
    public static int findInteger(int n, int k) {
        // Write your code here
        int oddcount=(n+1)/2;
        return (k<=oddcount)?2*k-1:2*(k-oddcount);
    }
    public static void main(String[] args) {
        System.out.println("find integer");
        int n=5;
        int k=3;
        System.out.println(findInteger(n,k));
    }
}
