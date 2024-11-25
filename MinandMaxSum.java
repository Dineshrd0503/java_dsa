import java.util.*;
public class MinandMaxSum{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Integer> a=new ArrayList<>();
        System.out.println("enter size of array");
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        a.add(sc.nextInt());
        Collections.sort(a);
        minmaxsum(a);
    }
    public static void minmaxsum(List<Integer> a){
        int minsum=0,maxsum=0;
        for(int n:a){
            if(a.indexOf(n)<a.size()-1)
            minsum+=n;
        }
        for(int n:a){
            if(a.indexOf(n)>0)
            maxsum+=n;
        }
        System.out.println(minsum+" "+maxsum);
    }
}