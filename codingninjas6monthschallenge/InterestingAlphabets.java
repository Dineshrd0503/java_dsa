package codingninjas6monthschallenge;

import java.util.ArrayList;

public class InterestingAlphabets {
    public static ArrayList<ArrayList<Character>> interestingPattern(int n) {
        ArrayList<ArrayList<Character>> result=new ArrayList<>();

        // Write your code here.
        for(int i=n-1;i>=0;i--){
            ArrayList<Character> row=new ArrayList<>();

            for(int j=i;j<n;j++){
                char c=(char)('A'+j);
                row.add(c);

            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Character>> pattern = interestingPattern(n);
        for (ArrayList<Character> row : pattern) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
