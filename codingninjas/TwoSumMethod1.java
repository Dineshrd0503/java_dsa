package codingninjas;
import java.util.HashSet;
import java.util.Set;
public class TwoSumMethod1 {
    public static String read(int n, int []book, int target){
        Set<Integer> seen=new HashSet<>();
        for(int n1:book){
            int complement=target-n1;
            if(seen.contains(complement))
                return "YES";
            seen.add(n1);
        }
        return "NO";

        // Write your code here.
    }
    public static void main(String[] args) {
        int n = 5;
        int[] book = {1, 3, 5, 7, 9};
        int target = 8;
        System.out.println(read(n, book, target));
    }
}
