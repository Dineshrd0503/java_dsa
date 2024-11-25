public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums = {3, 2, 3};
        int result = solution.majorityElement(nums);
        System.out.println("Majority element is: " + result);
    }
}