import java.util.*;

public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int k = 0; // count of unique elements
        for (int i = 0; i < nums.length; i++) {
            if (!s.contains(nums[i])) {
                s.add(nums[i]);
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicate solution = new RemoveDuplicate();
        int[] nums = {1, 1, 2};
        int k = solution.removeDuplicates(nums);
        System.out.println("Output: " + k);
        System.out.print("nums = [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}