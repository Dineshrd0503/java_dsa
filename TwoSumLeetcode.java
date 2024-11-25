import java.util.*;  

public class TwoSumLeetcode {  
    public static void main(String[] args) {
       
       int[] a={2,7,11,15};
       int target=54;
       System.out.println(returnindices(a,target));
       
    }
    public  static Set<Integer> returnindices(int[] a,int target){
         Set<Integer> s=new HashSet<>();
        for(int i=0;i<=a.length;i++){
           for(int j=i+1;j<=a.length-1;j++){
               if(a[i]+a[j]==target){
               s.add(i);
               s.add(j); 
               
               }
           }
       }
       return s;
      
    }
}