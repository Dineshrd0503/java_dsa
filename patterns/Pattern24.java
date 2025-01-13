package patterns;

import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Pattern24{

    public static ArrayList<ArrayList<Character>> interestingPattern(int n) {
        ArrayList<ArrayList<Character>> result=new ArrayList<>();
        for(int i=n;i>=1;i--){
            ArrayList<Character> row=new ArrayList<>();
            char ch=(char)('A'+i-1);
            for(int j=i;j<=n;j++){
                row.add(ch);
                ch++;

            }
            result.add(row);
        }
        return result;

        // Write your code here.
    }
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Character>> pattern = interestingPattern(n);

        // Print the pattern
        for (ArrayList<Character> row : pattern) {
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
