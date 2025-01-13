package codingninjas;
//You are given a number ‘N’ and a query ‘Q.’ If ‘Q’ is 1, then you have to return the sum of all integers from 1 to ‘N,’ else if ‘Q’ is equal to 2 then you have to return the product of all integers from 1 to ‘N.’ Since the product can be very large, return it modulo 10 ^ 9 + 7.
//
//For example
//
//Given ‘N’ = 4, ‘Q’ = 1.
//Then the answer is 10 because the sum of all integers between 1 and 4 are 1, 2, 3, and 4. Hence 1 + 2 + 3 + 4 is equal to 10.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= ‘T’ <= 10
//        1 <= ‘N’ <= 10^4
//        1 <= ‘Q’ <= 2
//
//Time Limit: 1 sec.
////Sample Input 1 :
//        2
//        4 1
//        4 2
//Sample Output 1 :
//        10
//        24
//Explanation of the Sample Input 1:
//In the first test case, the answer is 10 because all integers between 1 and 4 are 1, 2, 3, and 4. Hence 1 + 2 + 3 + 4 is equal to 10.
//
//
//In the second test case, the answer is 25 because all integers between 1 and 4 are 1, 2, 3, and 4. Hence 1 * 2 * 3 * 4 is equal to 24.
//Sample Input 2 :
//        2
//        5 1
//        5 2
//Sample Output 2 :
//        15
//        120
public class SumOrProduct {
    public static long sumOrProduct(int n, int q) {
        long sum=0,product=1;
        final int mod=1000000007;
        switch(q){
            case 1 ->{
                for(int i=1;i<=n;i++)
                    sum+=i;
                return sum;
            }
            case 2 ->{
                for(int i=1;i<=n;i++)
                    product=(product*i)%mod;
                return product;
            }

            // Write your code here
        }
        return 1L;
    }
    public static void main(String[] args) {
        int n = 5, q = 1;
        System.out.println(sumOrProduct(n, q));
    }
}
