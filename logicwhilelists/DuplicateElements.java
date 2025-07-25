package logicwhilelists;

import java.util.Arrays;
import java.util.HashSet;

public class DuplicateElements {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        HashSet<Integer> set=new HashSet();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                System.out.println("match found");
                return;
            }
            set.add(nums[i]);
        }
        System.out.println("unique array");

    }
}
