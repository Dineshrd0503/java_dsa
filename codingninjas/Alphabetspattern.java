package codingninjas;

import java.util.ArrayList;

//Problem statement
//As a part of its competition, the school will conduct a codeathon, Lock the Code, where it has been given a value, and the participants have to decode it.
//
//The participants are given a value denoting the number of rows in the matrix; they need to print the pattern.
//
//Example :
//
//        For N=5, Pattern:
//E
//        DE
//CDE
//        BCDE
//ABCDE
//Among the participants, Ninja is new to programming and doesn’t have much experience; he asks you to solve the problem. Can you help solve this problem?
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 50
//        1 <= N <= 26
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        5
//        4
//Sample Output 1:
//E
//        DE
//CDE
//        BCDE
//ABCDE
//
//        D
//CD
//        BCD
//ABCD
//Explanation for Sample Input 1:
//In the first test case, value of ‘N’ is 5, so print the ‘N’ rows from 1 to ‘N’ where in each row start from (N - i - 1)the character which goes on till ‘Nth character. Hence the answer is [‘E’,’DE’,’CDE,’ BCDE’,’ABCDE’].
//
//In the second test case, the value of ‘N’ is 4, so print the ‘N’ rows from 1 to ‘N’ where each row starts from (N - i - 1)the character, which goes on till ‘Nth character. Hence the answer is [‘D’,’CD’,BCD’,’ABCD’].
//Sample Input 2:
//        2
//        3
//        2
//Sample Output 2:
//C
//        BC
//ABC
//
//        B
//AB




public class Alphabetspattern {
    public static ArrayList<ArrayList<Character>> interestingPattern(int n) {

        // Write your code here.
        ArrayList<ArrayList<Character>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Character> row=new ArrayList<>();
            char start=(char)(65+(n-i-1));
            for(int j=0;j<=i;j++)
                row.add((char)(start+j));
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Character>> result = interestingPattern(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(result.get(i).get(j) + " ");
            System.out.println();
        }
    }

}
