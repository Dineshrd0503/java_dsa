package codingninjas;

import java.util.Scanner;

public class PrimeNumbersUptoN {
    public static void main(String[] args) {

        /* Your class should be named MinimumSum.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=2;i<=n;i++){
            if(check(i))
                System.out.println(i);
        }



    }
    private static boolean check(int n){
        if(n<=1)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

}
