import java.util.*;
public class LinearSearch{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of list");
        int n=sc.nextInt();
        List<Integer> a=new ArrayList<Integer>(n);
        for(int i=0;i<n;i++){
            System.out.println("enter "+i+"element :");
            a.add(i,sc.nextInt());
        }
        System.out.println("enter key to search");
        int key=sc.nextInt();
        int flag=0;
        for(int n1:a){
            if(n1==key){
                System.out.println("element found at index"+a.indexOf(n1));
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("element not found");
        }

    }
}