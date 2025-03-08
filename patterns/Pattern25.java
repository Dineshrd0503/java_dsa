package patterns;

//Problem statement
//You are given an integer ‘N’. Your task is to print a pattern with the following description
//
//The pattern will consist of ‘N’ lines.
//
//        For 1 <= ‘i’ <= ‘N’ ‘i’th line consists of a string of ‘N’  + 1 - ‘i’  ‘*’ characters.
//For example:
//
//If ‘N’ is 5 then the pattern will be.
//
//*****
//        ****
//        ***
//        **
//        *
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        2
//        5
//        3
//Sample Output 1:
//        *****
//        ****
//        ***
//        **
//        *
//        ***
//        **
//        *
//Explanation of Sample Input 1:
//Test Case 1:
//
//Given ‘N’ = 5
//We will print the pattern as description first line will contain a string of 5 ‘*’, the second line will contain a string of 4 ‘*’, the third line will contain 3 ‘*’, the fourth line will contain 2 ‘*’ and the fifth line will contain 1 ’*’.
//
//Test Case 2:
//
//Given ‘N’ = 3
//For 1 <= ‘i’ <= 3  , ‘i’th line contains 4 - ’i’, ‘*’ characters.
//Sample Input 2:
//        2
//        1
//        2
//Sample Output 2:
//        *
//        **
//        *
//Explanation of Sample Input 2:
//Test Case 1:
//
//Given ‘N' = 1
//There will be only 1 line and that will contain a single ‘*’.
//
//Test Case 2:
//
//Given ‘N’ = 2
//First-line will contain 2 ‘*’ while the second line will contain 1 ‘*’ as per description.


public class Pattern25 {
    public static String[] printPatt(int n) {

        // Write your code here
        String[] result=new String[n];

        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n-i;j++ ){
                sb.append("*");

            }
            result[i]=sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        int n=5;
        String[] res=printPatt(n);
        for(String s:res)
            System.out.println(s);
    }

}
