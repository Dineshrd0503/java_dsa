import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> s = new TreeSet<>();
        for (int n1 : arr1)
            s.add(n1);
        for (int n2 : arr2)
            s.add(n2);
        for (int n3 : s)
            list.add(n3);
        return list;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {4, 5, 6, 7, 8};
        int n = arr1.length;
        int m = arr2.length;

        ArrayList<Integer> union = findUnion(arr1, arr2, n, m);

        System.out.println("Union of the two arrays: " + union);
    }
}