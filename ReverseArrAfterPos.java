import java.util.ArrayList;

public class ReverseArrAfterPos {
    public static void reverseArray(ArrayList<Integer> arr, int m) {
        int left = m + 1; // Start from the index after m
        int right = arr.size() - 1; // Last element of the array

        // Swap the elements to reverse the subarray
        while (left < right) {
            // Swap arr[left] and arr[right]
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);

            // Move pointers towards the middle
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        int m = 3;  // Given M

        reverseArray(arr, m);

        // Print the updated array
        System.out.println(arr);
    }
}
