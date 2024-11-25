import java.util.*;
public class SubSetSequences {
    public static void main(String[] args) {
        //printing all the subsets  of a strting
        int n=5;
        ArrayList<Integer> list=new ArrayList<>();
        subsequences(n,list);
    }
    public static void subsequences(int n, ArrayList<Integer> list) {
        if(n==0){
            for(int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
            System.out.println();
            return;
        }
        //add element
        list.add(n);
        subsequences(n-1, list);
        //remove element
        list.remove(list.size()-1);
        subsequences(n-1, list);
    }
    
}
