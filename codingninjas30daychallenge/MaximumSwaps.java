package codingninjas30daychallenge;

//Problem statement
//Given a positive integer N, you can do the following operation at most once
//
//a) Swap two digits of the integer N.
//
//You need to determine the largest integer you can get by performing the above operation at most once.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= N <= 10^9
//
//Time limit: 1 sec
//Sample Input 1:
//        2
//        4589
//        99538
//Sample Output 1:
//        9584
//        99835
//Explanation Of Sample Input 1:
//For the first test case, swap the first digit with the last digit, So, return 9584.
//For the second test case, swap the third digit with the last digit. So, return 99835.
//Sample Input 2:
//        2
//        4321
//        18
//Sample Output 2:
//        4321
//        81
//Explanation Of Sample Input 2:
//For the first test case, the number given is biggest among all possible answers, So, return 4321.
//For the second test case, swap the first digit with the last digit. So, return 81.



public class MaximumSwaps {
    public static int maximumSwap(int n){
        // Write your code here.
        char[] digits=Integer.toString(n).toCharArray();
        int[] last=new int[10];
        for(int i=0;i<digits.length;i++)
            last[digits[i]-'0']=i;
        for(int i=0;i<digits.length;i++){
            for(int d=9;d>digits[i]-'0';d--){
                if(last[d]>i){
                    char temp=digits[i];
                    digits[i]=digits[last[d]];
                    digits[last[d]]=temp;
                    return Integer.parseInt(new String(digits));

                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println("maximum swap");
        int n=2736;
        System.out.println(maximumSwap(n));
    }
}
