package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//You are the Supreme Ninja Warrior on a visit to Ninja Class, and class can be represented as a rectangular matrix ‘ARR’ of ‘N’ rows and ‘M’ columns.
//
//Each Ninja has a skill level, and each element in matrix ‘ARR’ represents the skill level of the Ninja present in the class. More formally, ‘ARR[i][j]’ represents the skill level of Ninja sitting in the ‘jth’ column of the ‘ith’ row.
//
//A ninja is said to be ‘Chunin’ if he has maximum skill among all Ninjas in his column and minimum skill level among all Ninjas in his row.
//
//Can you find all the ‘Chunin’ Ninjas present in the class?
//
//Example :
//N = 3 M = 3
//ARR = [ [3, 4, 5], [2, 7, 6] , [1, 2, 4] ]
//
//Ninja at Position (0,0) has maximum skill in ‘0th’ column and minimum skill in ‘0th’ row, it is the only Chunin Ninja.
//So, we return [ 3 ] as our ‘ANS’.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 10
//        1 <= N , M <= 10^5
//        0 <= ARR[i][j] <= 10^9
//Sum of N*M over all Test cases <= 10^5
//
//Time Limit: 1 sec
//Sample Input 1 :
//        2
//        2 2
//        3 4
//        2 5
//        2 3
//        3 4 5
//        4 5 6
//Sample Output 1 :
//        3
//        4
//Explanation Of Sample Input 1 :
//For test case 1,
//With skill level '3' at position (0,0), the Ninja is the only 'Chunin' Ninja as it has maximum skill level in its column and minimum skill level in its row.
//
//For test case 2,
//With skill level '4' at position (1,0), the Ninja is the only 'Chunin' Ninja as it has maximum skill level in its column and minimum skill level in its row.
//Sample Input 2 :
//        1
//        1 1
//        1
//Sample Output 2 :
//        1

public class MaxInColMinInRow {
    public static List< Integer > chuninNinja(int n, int m, int arr[][]) {
        // Write your code here.
        int[] rows=new int[n];
        int[] cols=new int[m];
        Arrays.fill(rows,Integer.MAX_VALUE);
        Arrays.fill(cols,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]<rows[i])
                    rows[i]=arr[i][j];
                if(arr[i][j]>cols[j])
                    cols[j]=arr[i][j];
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==rows[i]&&arr[i][j]==cols[j])
                    result.add(arr[i][j]);
            }
        }
        return result;

    }
   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    System.out.println("finding the max in col and min in row");
    int[][] arr = {{3,4},
            {1,8},
            {2,6},
            {7,5}};
    List<Integer> result = chuninNinja(2, 2, arr);
    for (int i : result) {
        System.out.println(i);
    }
}
}
