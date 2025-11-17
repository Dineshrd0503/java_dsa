package greedyalgorithms;

/*
Break The Board - Naukri Code360 Problem

PROBLEM STATEMENT:
You are given a board of length L and width W. The objective is to cut the board into unit squares.
- You can make vertical and horizontal cuts.
- Each cut has a cost.
- costL[] contains the cost of L-1 vertical cuts.
- costW[] contains the cost of W-1 horizontal cuts.

You need to minimize the total cutting cost.

Approach:
- At each step, pick the cut with maximum cost available.
- When making a vertical cut, the cost is cutCost * current horizontal pieces.
- When making a horizontal cut, the cost is cutCost * current vertical pieces.
- Repeat until all cuts are made.

Below is the complete Java solution with static sample inputs and a main method.
*/

import java.util.*;

public class BreakTheBoard {

    // Function to compute minimum cost to break the board
    public static int minimumCost(ArrayList<Integer> rowCost, ArrayList<Integer> colCost, int l, int w) {
        Collections.sort(rowCost); // sort ascending
        Collections.sort(colCost); // sort ascending

        int i = rowCost.size() - 1; // pointer for vertical cuts
        int j = colCost.size() - 1; // pointer for horizontal cuts
        int totalCost = 0, verticalPieces = 1, horizontalPieces = 1;

        while (i >= 0 && j >= 0) {
            if (rowCost.get(i) >= colCost.get(j)) {
                totalCost += rowCost.get(i) * horizontalPieces;
                verticalPieces++;
                i--;
            } else {
                totalCost += colCost.get(j) * verticalPieces;
                horizontalPieces++;
                j--;
            }
        }

        while (i >= 0) {
            totalCost += rowCost.get(i) * horizontalPieces;
            i--;
        }
        while (j >= 0) {
            totalCost += colCost.get(j) * verticalPieces;
            j--; // Make sure to decrement j!
        }
        return totalCost;
    }

    public static void main(String[] args) {
        // Static sample input
        // Board size: L = 3, W = 3
        // rowCost: costs for vertical cuts (L-1 elements)
        // colCost: costs for horizontal cuts (W-1 elements)
        int l = 3;
        int w = 3;
        ArrayList<Integer> rowCost = new ArrayList<>(Arrays.asList(2, 1)); // vertical cuts
        ArrayList<Integer> colCost = new ArrayList<>(Arrays.asList(2, 1)); // horizontal cuts

        int minCost = minimumCost(rowCost, colCost, l, w);
        System.out.println("Minimum cost to break the board = " + minCost);
    }
}
