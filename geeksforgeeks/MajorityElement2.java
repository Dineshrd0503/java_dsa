package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
public class MajorityElement2 {
    public List<Integer> findMajority(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums)
            map.put(n,map.getOrDefault(n,0)+1);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>nums.length/3)
                list.add(entry.getKey());
        }
        Collections.sort(list);
        return list;
        // Your code goes here.
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 3, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5};
        MajorityElement2 obj = new MajorityElement2();
        List<Integer> result = obj.findMajority(nums);
        System.out.println(result);
    }
}
