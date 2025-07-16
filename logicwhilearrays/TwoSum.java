package logicwhilearrays;

import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        int[] a = {1, 2, 3, 4, 5};
        int[] result = new int[2];
        int target = 9; // Example target sum
        boolean found = false;
        for (int i = 0; i < a.length; i++) {
            int complement = target - a[i];
            if (set.contains(complement)) {
                result[0] = complement;
                result[1] = a[i];
                found = true;
                break;
            }
            set.add(a[i]);
        }

            System.out.println(found?"Pair found: " + result[0] + ", " + result[1]:"No pair found with the given sum.");

    }
}
