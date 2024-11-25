import java.util.*;
public class SelectionSort {
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
        for(int i=0;i<a.size();i++){
            int min=i;
            for(int j=i+1;j<a.size();j++){
                if(a.get(j)<a.get(min)){
                    min=j;
                }
            }
            int temp=a.get(min);
            a.set(min,a.get(i));
            a.set(i,temp);
        System.out.println();
        for(int n1:a)
        System.out.println(n1+" ");
        }

        
    }
    
}
