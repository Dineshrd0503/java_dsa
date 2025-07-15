package logicwhilearrays;

public class SortArrayFromPosK {
    public static void main(String[] args) {
        int[] a={1,45,6,13,4,3};
        int k=2;
        int n = a.length;
        // Sort the array from position k
        for (int i = k; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    // Swap a[i] and a[j]
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        // Print the sorted array
        System.out.print("Sorted array from position " + k + ": ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
