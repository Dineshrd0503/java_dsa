package strings;

//Problem statement
//You are given three non-zero numbers ‘A’, ‘B’, and ‘C’. The task is to find the number formed by concatenating the largest digit from each of these numbers in the order of ‘A’, ‘B’, and ‘C’.
//
//For Example :
//A = 5678, B = 45 and C = 769
//The largest digit in ‘A’ is ‘8’, ‘B’ is ‘5’, and ‘C’ is ‘9’. The new number formed by concatenating the largest digit from each of these numbers is ‘859’. So, the answer is ‘859’.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 10^4
//        1 <= A, B, C <= 10^6
//
//Time limit: 1 Sec
//Sample Input 1 :
//        2
//        4554 292 123567
//        90909 111 876
//Sample Output 1 :
//        597
//        918
//Explanation Of Sample Input 1 :
//Test Case 1:
//a = 4554, b = 292 and c = 123567
//The largest digit in ‘a’ is ‘5’, ‘b’ is ‘9’, and ‘c’ is ‘7’. The new number formed by concatenating the largest digit from each of these numbers is ‘597’. So, the answer is ‘597’.
//
//Test Case 2:
//a = 90909, b = 111 and c = 876
//The largest digit in ‘a’ is ‘9’, ‘b’ is ‘1’, and ‘c’ is ‘8’. The new number formed by concatenating the largest digit from each of these numbers is ‘918’. So, the answer is ‘918’.
//Sample Input 2 :
//        2
//        324865 123 456
//        1 22 333
//Sample Output 2 :
//        836
//        123



public class ConcatenateTheLargestDigit {
    public static int concatLargestDigit(int a, int b, int c)
    {
        String s=findmax(a)+findmax(b)+findmax(c);

        //    Write your code here.
        return Integer.parseInt(s);
    }
    private static String findmax(int n){
        int max=0;
        while(n>0){
            int a=n%10;
            max=Math.max(max,a);
            n/=10;
        }
        return Integer.toString(max);

    }

    public static void main(String[] args) {
        System.out.println("concatenate the largest digit");
        System.out.println(concatLargestDigit(123, 678, 456));
    }
}
