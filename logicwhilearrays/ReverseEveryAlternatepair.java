package logicwhilearrays;

public class ReverseEveryAlternatepair {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        for (int i = 0; i < n ; i += 4) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
