package geeksforgeeks;
import java.util.HashMap;
public class CountPositiveNegativePairs {
    public static long countPositiveNegativePairs(int[] arr)
    {
        //Write your code here
        long count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:arr)
            map.put(n,map.getOrDefault(n,0)+1);
        for(int n:map.keySet()){
            if(n>0&&map.containsKey(-n))
                count+=Math.min(map.get(n),map.get(-n));

        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("count positive negative pairs");
        int[] arr={1,1,2,-1,2};
        System.out.println(countPositiveNegativePairs(arr));
    }

}
