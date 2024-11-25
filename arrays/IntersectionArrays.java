package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class IntersectionArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of first array
        System.out.print("Enter the size of first array: ");
        int n = sc.nextInt();

        // Input elements of first array
        ArrayList<Integer> arr1 = new ArrayList<>();
        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n; i++) {
            arr1.add(sc.nextInt());
        }

        // Input size of second array
        System.out.print("Enter the size of second array: ");
        int m = sc.nextInt();

        // Input elements of second array
        ArrayList<Integer> arr2 = new ArrayList<>();
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < m; i++) {
            arr2.add(sc.nextInt());
        }

        // Find intersection
        ArrayList<Integer> intersection = findArrayIntersection(arr1, n, arr2, m);

        // Print the intersection
        System.out.println("Intersection of the two arrays is: " + intersection);

        sc.close();
    }

    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1.get(i) < arr2.get(j))
                i++;
            else if (arr2.get(j) < arr1.get(i))
                j++;
            else {
                list.add(arr1.get(i));
                i++;
                j++;
            }
        }
        return list;
    }
}
