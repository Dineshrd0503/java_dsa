package geeksforgeeks;
//Problem statement
//You are given a number 'N' and its reverse 'R'.
//
//
//
//Return the number raised to the power of its own reverse. As answers can be very large, print the result modulo '10^9 + 7'.
//
//
//
//For Example:
//
//For 'N' = 20, 'R' = 2
//The answer is 400 since 20^2 as the reverse of 20 is 2.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        14 41
//Sample Output 1:
//        722400406
//Explanation of sample output 1:
//        'N' = 14
//Answer is 14^41 as the reverse of 14 is 41.
//when divided by 1000000007 gives remainder as 722400406
//Sample Input 2:
//        2 2
//Sample Output 2:
//        4
//Constraints:
//        1 <= N <= 10^9
//Time Limit: 1 sec

public class PowerOfNumbers {
    public static int power(int n, int r){
        long mod=1000000007;
        long base=n;
        long result=1;
        while(r>0){
            if(r%2==1)
                result=(result*base)%mod;
            base=(base*base)%mod;
            r/=2;
        }
        return (int) result;
        // Write your code here.
    }
    public static void main(String[] args) {
        int n = 3, r = 4;
        System.out.println(power(n, r));
    }
}
