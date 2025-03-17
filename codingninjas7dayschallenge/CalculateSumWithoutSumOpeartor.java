package codingninjas7dayschallenge;


//Ninja is trying to write a function that takes two integers and returns their sum. But, due to some faults in his keyboard, he can not use the “+”, operator, which means he is not able to simply return ‘A’ + ‘B’, where ‘A’ and 'B' are the numbers to be added. You need to help Ninja in finding the sum of two numbers without using the "+" operator anywhere in your code.
//
//        Note:
//You should also not use the increment "++" operator too.
//For example :
//You are given A = 4, B = 6, their sum = 10, you need to return 10.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 100
//        -10000 <= A, B <= 10000
//
//where ‘T’ is the number of test cases and ‘A’ and ‘B’ are the two integers.
//
//Time limit: 1 sec
//Sample Input 1:
//        2
//        1 1
//        4 6
//Sample Output 1:
//        2
//        10
//Explanation of sample input 1:
//In the first test case,
//Sum of the two numbers = 1 + 1 = 2.
//
//In the second test case,
//Sum of the two numbers = 4 + 6 = 10.
//Sample Input 2:
//        2
//        -1 1
//        0 1
//Sample Output 2:
//        0
//        1
//Explanation of sample input 1:
//In the first test case,
//Sum of the two numbers = (-1) + 1 = 0.
//
//In the second test case,
//Sum of the two numbers = 0 + 1 = 1.



public class CalculateSumWithoutSumOpeartor {
    public  static int getSum(int a, int b){
        // Write your code here.
        while(b!=0){
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println("sum without sum operator");
        System.out.println(getSum(5,7));
    }
}
