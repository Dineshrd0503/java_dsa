package logicwhilearrays;

public class MaxEleInFirstHalf {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = a.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n / 2; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        System.out.println("Maximum element in the first half of the array: " + max);
    }
}
