package codingninjas;
//Given an integer ‘N’, you are supposed to return the square of the given integer without using multiplication (*), division (/) or power function (pow()).
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 50
//        -10000 <= N <= 10000
//
//Time Limit: 1 sec.
//Sample Input 1:
//        2
//        3
//        -4
//Sample Output 1:
//        9
//        16
//Explanation to Sample Input 1:
//In the first test case, the square of 3 is 9.
//
//In the second test case, the square of -4 is 16.
//Sample Input 2:
//        2
//        -13
//        1
//Sample Output 2:
//        169
//        1
public class SquareOfN {
    public static int calculateSquare(int num)
    {
        int square=0,odd=1;
        for(int i=0;i<Math.abs(num);i++){
            square+=odd;
            odd+=2;
        }
        return square;
        //    Write your code here.
    }
    public static void main(String[] args) {
        int num = 5;
        System.out.println(calculateSquare(num));
    }
}
