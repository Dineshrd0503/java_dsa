import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort3 {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 2, 8, 3, 1, 6, 4);
        List<Integer> sortedArr = quickSort(arr);
        System.out.println(sortedArr); // [1, 2, 3, 4, 5, 6, 8]
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() <= 1) {
        return arr;
    }

        // Select the pivot element (in this case, the middle element)
        int pivot = arr.get(arr.size() / 2);

        // Create three lists: elements less than the pivot, equal to the pivot, and greater than the pivot
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Partition the array around the pivot
        for (int x : arr) {
            if (x < pivot) {
                left.add(x);
            } else if (x == pivot) {
                middle.add(x);
            } else {
                right.add(x);
            }
        }

        // Recursively sort the left and right lists
        left = quickSort(left);
        right = quickSort(right);

        // Combine the sorted lists and the middle list
        left.addAll(middle);
        left.addAll(right);

        return left;
    }}
