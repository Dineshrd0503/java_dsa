import java.util.HashSet;

public class LargestNumber {
    public static int largestNumber(int[] a, int n) {
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > max)
                max = a[i];
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        for (int i = max; i >= 1; i--) {
            if (set.contains(i) && set.contains(-i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, -1, -2, -3, -4, -5};
        int n = arr.length;

        int result = largestNumber(arr, n);

        if (result == -1) {
            System.out.println("No such number exists");
        } else {
            System.out.println("Largest number K such that both K and -K are present: " + result);
        }
    }
}