package codingninjas30daychallenge;

//Problem statement
//Given an integer 'N', you need to determine whether the given integer is a power of 3 or not.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= N <= 10^9
//
//Time limit: 1 sec
//Sample Input 1:
//        2
//        81
//        6
//Sample Output 1:
//        1
//        0
//Explanation Of Sample Input 1:
//For the first test case, 81 = 3^4. So, return 1.
//For the second test case, 6 = 2 * 3^1. So, return 0.
//Sample Input 2:
//        2
//        27
//        1
//Sample Output 2:
//        1
//        1
//Explanation Of Sample Input 2:
//For the first test case, 27 = 3^3. So, return 1.
//For the second test case, 1 =  3^0. So, return 1.



public class CheckIfNIsPowerOfThree {
    public static boolean isPowerOfThree(int n) {
        // Write your code here
        if(n<=0)
            return false;
        while(n%3==0){
            n/=3;
        }
        return n==1;
    }

    public static void main(String[] args) {
        System.out.println("Check if N is power of three");
        int n=27;
        System.out.println(isPowerOfThree(n));
    }
}
