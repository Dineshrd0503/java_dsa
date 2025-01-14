import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of list");
        int n=sc.nextInt();
        List<Integer> a=new ArrayList<Integer>(n);
        for(int i=0;i<n;i++){
            System.out.println("enter "+i+"element :");
            a.add(i,sc.nextInt());
        }
        Collections.sort(a);
        System.out.println("aorted lsit is ");
        for(int i:a)
        System.out.print(i+" ");
        System.out.println("enter key to search");
        int key=sc.nextInt();
        int result=binarysearch(a,0,n-1,key);
        if(result==-1)
        System.out.println("element not found");
        else
        System.out.println("element found at index "+result);
        
    }
    public static int binarysearch(List<Integer> a,int low,int high,int key){
        if(low<=high){
            int mid=low+(high-low)/2;
            if(a.get(mid)==key)
                return mid;
            
            else if(a.get(mid)>key)
                return binarysearch(a,low,mid-1,key);
            
            else
                return binarysearch(a,mid+1,high,key);
            
           
    }
    return -1;
    
}
}
