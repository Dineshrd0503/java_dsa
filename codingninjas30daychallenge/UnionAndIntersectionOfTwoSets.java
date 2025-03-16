package codingninjas30daychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersectionOfTwoSets {
    public static ArrayList<Integer> diffSimCards(ArrayList<Integer> pack1, int n, ArrayList<Integer> pack2, int m) {
        // Write your code here.
        Set<Integer> set1 = new HashSet<>(pack1);
        Set<Integer> set2 = new HashSet<>(pack2);

        // Calculate union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // Calculate intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Convert results back to lists
        ArrayList<Integer> result = new ArrayList<>();
        result.add(union.size()); // Number of different types
        result.add(intersection.size()); // Number of common types

        return result;
    }
    public static void main(String[] args) {
        System.out.println("Finding intersection and union of two sets");

        ArrayList<Integer> pack1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> pack2 = new ArrayList<>(Arrays.asList(1, 2));

        ArrayList<Integer> result = diffSimCards(pack1, pack1.size(), pack2, pack2.size());

        System.out.println("Number of different types: " + result.get(0));
        System.out.println("Number of common types: " + result.get(1));
    }
}