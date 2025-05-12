package wiprointerviewforda;
import java.util.*;

public class FlattenList {
    // Problem: Flatten a nested list of integers
    // Sample Test Cases:
    // Input: list = [1, [2, 3], [4, [5, 6]]]
    // Output: [1, 2, 3, 4, 5, 6]
    // Input: list = []
    // Output: []
    // Input: list = [[1], [2], [3]]
    // Output: [1, 2, 3]

    public static List<Integer> flatten(List<?> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (Object item : nestedList) {
            if (item instanceof List) {
                result.addAll(flatten((List<?>) item));
            } else {
                result.add((Integer) item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        List<Object> list1 = Arrays.asList(1, Arrays.asList(2, 3), Arrays.asList(4, Arrays.asList(5, 6)));
        System.out.println("Test Case 1:");
        System.out.println(flatten(list1));

        // Test Case 2
        List<Object> list2 = Arrays.asList();
        System.out.println("\nTest Case 2:");
        System.out.println(flatten(list2));

        // Test Case 3
        List<Object> list3 = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3));
        System.out.println("\nTest Case 3:");
        System.out.println(flatten(list3));
    }
}