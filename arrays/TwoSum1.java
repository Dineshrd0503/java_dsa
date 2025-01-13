package arrays;

import java.util.Arrays;

public class TwoSum1 {
    public static String read(int n, int []book, int target){
        Arrays.sort(book);
        int i=0,j=n-1;
        while(i<j){
            if(book[i]+book[j]==target)
                return "YES";
            if(book[i]+book[j]<target)
                i++;
            else if(book[i]+book[j]>target)
                j--;
        }
        return "NO";
        // Write your code here.
    }

    public static void main(String[] args) {
        int n = 5;
        int[] book = {1, 3, 5, 7, 9};
        int target = 8;
        System.out.println(read(n, book, target));
    }
}