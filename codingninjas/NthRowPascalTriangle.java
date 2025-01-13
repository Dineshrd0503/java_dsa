package codingninjas;

import java.util.ArrayList;

public class NthRowPascalTriangle {
    private static ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Integer> row = new ArrayList<>();

        // The first element is always 1
        row.add(1);

        // Calculate the rest of the elements in the nth row
        for (int k = 1; k < n; k++) { // Loop runs for (n - 1) times
            // Calculate the next element using the previous one
            long value = (long) row.get(k - 1) * (n - k) / k;
            row.add((int) value);
        }

        return row;

    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Integer> row = nthRowOfPascalTriangle(n);
        System.out.println("The " + n + "th row of Pascal's Triangle is: " + row);
    }

}
