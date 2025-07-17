package logicwhilearrays;
/*
Problem Statement:
Given an integer array, sort the array such that all even numbers appear before all odd numbers. Within the even and odd groups, the numbers should be sorted in ascending order.

Sample Input 1:
a = {3, 1, 2, 4}
Sample Output 1:
2 4 1 3

 */
public class SortTheArrayBasedOnParity {
    public static void main(String[] args) {
        int[] a={3, 1, 2, 4};
        int n = a.length;
        for (int i = 0; i < n-1 ; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((a[i] % 2 != a[j] % 2) && (a[i] > a[j])) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.print("Sorted array based on parity: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
