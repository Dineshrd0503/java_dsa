import java.util.*;
public class TwiceElement {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(15, 15, 67, 89, 1, 4, 5));
        System.out.println("Original List: "+a);
        int result=twiceelement(a);
        if(result==-1)
        System.out.println("No two elements occur twice");
        else
        System.out.println("Two elements occur twice: "+result);
    }
    
    public static int twiceelement(List<Integer> a){
        Map<Integer,Integer> s = new HashMap<>();
        for(int n:a)
        s.put(n,s.getOrDefault(n,0)+1);
       for(int n:a){
        if(s.get(n)==2)
        return n;
       }
        return -1;
        
    }
    
}
