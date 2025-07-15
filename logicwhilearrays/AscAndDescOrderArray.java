package logicwhilearrays;/*
Problem Statement:
Write a Java program to sort an array such that the first half is in ascending order and the
second half is in descending order. The array is split at the midpoint (length / 2), and
bubble sort is used to achieve the desired order. For example, for the array
{2, 4, 6, 12, 5, 679, 523, 16, 73, 32, 7, 5}, the output should be
{2, 4, 5, 6, 7, 12, 679, 523, 73, 32, 16, 5}.

Assumptions:
- The array length is even for simplicity.
*/

public class AscAndDescOrderArray {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 12, 5, 679, 523, 16, 73, 32, 7, 5};
        int mid = a.length / 2;

        // Sort first half in ascending order
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        // Sort second half in descending order
        for (int i = 0; i < a.length - mid; i++) {
            for (int j = mid; j < a.length - 1 - i; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        System.out.print("Array in Ascending and Descending Order: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}