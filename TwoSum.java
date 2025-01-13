import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twosum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            map.put(nums[i], i);

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twosum(nums, target);
        System.out.println("Indices of two numbers that add up to " + target + " are: " + result[0] + " and " + result[1]);
    }
}