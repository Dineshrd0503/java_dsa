package codingninjas;
import java.util.*;
public class NthFibbonacci {



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fibbonacci(n));


        /* Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */


    }
    public static int fibbonacci(int n){
        if(n==1||n==2)
            return 1;
        int a=1,b=1,c=0;
        for(int i=3;i<=n;i++){
            c=a+b;
            a=b;
            b=c;

        }
        return c;
    }

}
