package recursion;
public class SumOfN {
    public static void main(String[] args) {
        int[] n={1,12,13,24,15};
        sum1(0,n,0);
        int a=5;
        sum2(1,a,0);
    }
    public static void sum1(int i,int[] n,int sum){
        if(i==n.length){
            System.out.println("sum of array is "+sum);
            return;
        }
        sum1(i+1,n,sum+n[i]);

    }
    public static void sum2(int i,int a,int sum){
        if(i>a){
            System.out.println("sum from 1 to "+a+" is "+sum);
            return;
        }
        sum2(i+1,a,sum+i);
    }

}
