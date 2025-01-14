import java.util.*;
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of list");
        int n=sc.nextInt();
        List<Integer> a=new ArrayList<Integer>(n);
        for(int i=0;i<n;i++){
            System.out.println("enter "+i+"element :");
            a.add(i,sc.nextInt());
        }
        System.out.println("before sorting");
        for(int i:a)
        System.out.println(i+" ");
        for(int i=0;i<a.size()-1;i++){
            for(int j=0;j<a.size()-i-1;j++){
                if(a.get(j)>a.get(j+1)){
                    int temp=a.get(j);
                    a.set(j,a.get(j+1));
                    a.set(j+1,temp);

                }
            }
            System.out.println();
            for(int n1:a)
            System.out.println(n1+" ");
        }
        System.out.println("after sorting");
        for(int i:a)
        System.out.println(i+" ");
        
    }
    
}
