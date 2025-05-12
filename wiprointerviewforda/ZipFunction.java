package wiprointerviewforda;
import java.util.*;

public class ZipFunction {
    // Problem: Implement a custom zip function to pair elements from two lists
    // Sample Test Cases:
    // Input: list1 = [1, 2, 3], list2 = [4, 5, 6]
    // Output: [[1, 4], [2, 5], [3, 6]]
    // Input: list1 = [1, 2], list2 = [3]
    // Output: [[1, 3]]
    // Input: list1 = [], list2 = [1, 2]
    // Output: []

    public static List<int[]> zip(List<Integer> list1, List<Integer> list2) {
        List<int[]> result = new ArrayList<>();
        int minLength = Math.min(list1.size(), list2.size());
        for (int i = 0; i < minLength; i++) {
            result.add(new int[]{list1.get(i), list2.get(i)});
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        System.out.println("Test Case 1:");
        List<int[]> result1 = zip(list1, list2);
        for (int[] pair : result1) {
            System.out.print(Arrays.toString(pair) + " ");
        }
        System.out.println();

        // Test Case 2
        List<Integer> list3 = Arrays.asList(1, 2);
        List<Integer> list4 = Arrays.asList(3);
        System.out.println("\nTest Case 2:");
        List<int[]> result2 = zip(list3, list4);
        for (int[] pair : result2) {
            System.out.print(Arrays.toString(pair) + " ");
        }
        System.out.println();

        // Test Case 3
        List<Integer> list5 = Arrays.asList();
        List<Integer> list6 = Arrays.asList(1, 2);
        System.out.println("\nTest Case 3:");
        List<int[]> result3 = zip(list5, list6);
        for (int[] pair : result3) {
            System.out.print(Arrays.toString(pair) + " ");
        }
        System.out.println();
    }
}