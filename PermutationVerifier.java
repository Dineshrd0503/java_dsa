import java.util.* ;
import java.io.*;
import java.util.Scanner;
public class PermutationVerifier {

    public static boolean isPermutation(String input1,String input2) {
        char[] a=input1.toCharArray();
        char[] b=input2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
        // Write your code here
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        boolean answer = isPermutation(input1,input2);
        if(answer){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

    }
}
