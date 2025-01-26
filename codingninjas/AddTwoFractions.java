package codingninjas;

public class AddTwoFractions {
    public static long[] addFraction(int a, int b, int c, int d) {
        // Write your code here.
        long denominator=(long) b*d;
        long numerator=(long)(a*d)+(long)(b*c);
        long gcd=gcd(numerator,denominator);
        numerator/=gcd;
        denominator/=gcd;
        return new long[]{numerator,denominator};
    }
    private static long gcd(long x,long y){
        while(y!=0){
            long temp=y;
            y=x%y;
            x=temp;
        }
        return x;
    }
    public static void main(String[] args) {
        long[] result=addFraction(1,2,3,2);
        System.out.println(result[0]+" "+result[1]);
    }
}
