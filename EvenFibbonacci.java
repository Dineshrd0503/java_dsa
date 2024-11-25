
import java.util.*;

public class EvenFibbonacci{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long r1=fibbonacciseries(n);
            System.out.println(r1);
        }
    }
    public static long fibbonacciseries(long n){
        int sum=0;
        for(int i=0;i<n;i++){
            if(fibbonacci(i)%2==0)
            sum+=i;
        }
        return sum;
        
    }
    public static long fibbonacci(int n){
        long sum = 0;
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            if (a % 2 == 0) {
                sum += a;
            }
            long temp = a;
            a = b;
            b = temp + b;
        }
        return sum;
    }
}
