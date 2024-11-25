import java.util.*;

public class MedianOfSortedArray{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> s = new ArrayList<>();
        for (int n : nums1)
            s.add(n);
        for (int n : nums2)
            s.add(n);
        double median = 0;
        Collections.sort(s);
        if (s.size() % 2 != 0)
            median = s.get((int) s.size() / 2);
        else
            median = (double) (s.get(s.size() / 2) + s.get(s.size() / 2 - 1)) / 2;
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }
}