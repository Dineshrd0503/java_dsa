package geeksforgeeks;

public class PowerOfN {
    public static long Pow(int x, int n) {
        if(n==0)
            return 1;
        long halfpower=Pow(x,n/2);
        if(n%2==0)
            return halfpower*halfpower;
        else
            return x*halfpower*halfpower;

        //Write your code here
    }
    public static void main(String[] args) {
        int x = 2, n = 5;
        System.out.println(Pow(x, n));
    }
}
