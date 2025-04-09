package codingninjas6monthschallenge;

// IntervalListIntersection.java

/*
Problem Statement:
You have been given two sorted arrays/lists of closed intervals ‘INTERVAL1’ and ‘INTERVAL2’.
A closed interval [x, y] with x < y denotes the set of real numbers ‘z’ with x <= z <= y.

Your task is to find the intersection of these two interval lists. The intersection of two closed intervals
is a set of real numbers that are either empty or represented as a closed interval.
For example, the intersection of [0, 2] and [1, 3] is [1, 2].

Note:
1. Each list of intervals is pairwise disjoint
2. INTERVAL1 and INTERVAL2 don't contain duplicate intervals
3. Return empty list if no intersection exists

Constraints:
1 <= T <= 100
0 <= N1 <= 5000
0 <= N2 <= 5000
0 <= INTERVAL1[i][0] <=10^5
INTERVAL1[i][0] < INTERVAL1[i][1] <= 10^5
0 <= INTERVAL2[i][0] <=10^5
INTERVAL2[i][0] < INTERVAL2[i][1] <= 10^5

Sample Input 1:
2
2 3
2 8 12 16
5 9 10 12 14 15
3 0
1 2 4 6 8 12

Sample Output 1:
5 8 12 12 14 15
Explanation: First test case intersections are [5,8], [12,12], [14,15]
Second test case has no intervals in INTERVAL2

Sample Input 2:
2
2 2
2 4 8 10
5 7 11 14
1 1
2 4
2 4

Sample Output 2:
[Empty for first test case]
2 4
*/

import java.util.*;

public class IntervalListIntersection {
    public static void main(String[] args) {
        // Test Case 1
        ArrayList<ArrayList<Integer>> interval1 = new ArrayList<>();
        interval1.add(new ArrayList<>(Arrays.asList(2, 8)));
        interval1.add(new ArrayList<>(Arrays.asList(12, 16)));

        ArrayList<ArrayList<Integer>> interval2 = new ArrayList<>();
        interval2.add(new ArrayList<>(Arrays.asList(5, 9)));
        interval2.add(new ArrayList<>(Arrays.asList(10, 12)));
        interval2.add(new ArrayList<>(Arrays.asList(14, 15)));

        ArrayList<ArrayList<Integer>> result = intersectionIntervals(interval1, interval2, 2, 3);
        printResult(result); // Output: [5,8], [12,12], [14,15]

        // Test Case 2
        interval1.clear();
        interval1.add(new ArrayList<>(Arrays.asList(1, 2)));
        interval1.add(new ArrayList<>(Arrays.asList(4, 6)));
        interval1.add(new ArrayList<>(Arrays.asList(8, 12)));

        interval2.clear();
        result = intersectionIntervals(interval1, interval2, 3, 0);
        printResult(result); // Output: []

        // Test Case 3 (From Sample Input 2)
        interval1.clear();
        interval1.add(new ArrayList<>(Arrays.asList(2, 4)));
        interval1.add(new ArrayList<>(Arrays.asList(8, 10)));

        interval2.clear();
        interval2.add(new ArrayList<>(Arrays.asList(5, 7)));
        interval2.add(new ArrayList<>(Arrays.asList(11, 14)));

        result = intersectionIntervals(interval1, interval2, 2, 2);
        printResult(result); // Output: []

        // Test Case 4 (From Sample Input 2)
        interval1.clear();
        interval1.add(new ArrayList<>(Arrays.asList(2, 4)));

        interval2.clear();
        interval2.add(new ArrayList<>(Arrays.asList(2, 4)));

        result = intersectionIntervals(interval1, interval2, 1, 1);
        printResult(result); // Output: [2,4]
    }

    private static void printResult(ArrayList<ArrayList<Integer>> result) {
        if(result.isEmpty()) {
            System.out.println("No intersections found");
            return;
        }
        for(ArrayList<Integer> interval : result) {
            System.out.print(interval.get(0) + " " + interval.get(1) + " ");
        }
        System.out.println();
    }

    public static ArrayList<ArrayList<Integer>> intersectionIntervals(
            ArrayList<ArrayList<Integer>> interval1,
            ArrayList<ArrayList<Integer>> interval2,
            int n1, int n2
    ) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;

        while(i < n1 && j < n2) {
            // Get current intervals
            int start1 = interval1.get(i).get(0);
            int end1 = interval1.get(i).get(1);
            int start2 = interval2.get(j).get(0);
            int end2 = interval2.get(j).get(1);

            // Calculate potential intersection
            int intersectStart = Math.max(start1, start2);
            int intersectEnd = Math.min(end1, end2);

            // Check if valid intersection exists
            if(intersectStart <= intersectEnd) {
                result.add(new ArrayList<>(Arrays.asList(intersectStart, intersectEnd)));
            }

            // Move pointer based on end values
            if(end1 < end2) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}

