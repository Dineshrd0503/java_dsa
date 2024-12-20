package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;

//You have been given two sorted arrays/lists of closed intervals ‘INTERVAL1’ and ‘INTERVAL2’. A closed interval [x, y] with x < y denotes the set of real numbers ‘z’ with x <= z <= y.
//
//        Now, your task is to find the intersection of these two interval lists.
//
//The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [0, 2] and [1, 3] is [1, 2].
//Sample Input 1:
//        2
//        2 3
//        2 8 12 16
//        5 9 10 12 14 15
//        3 0
//        1 2 4 6 8 12
//Sample output 1:
//        5 8 12 12 14 15
//Explanation of Sample output 1:
//For the first test case, INTERVAL1 is [[2, 8], [12, 16]] and INTERVAL2 is [[5, 9], [10, 12], [14, 15]] the intersections between INTERVAL1 and INTERVAL2 are [5 , 8], [12, 12] and [14, 15].
//For the second test case, since there is no interval present in INTERVAL2 hence there is no intersection.
//Sample Input 2:
//        2
//        2 2
//        2 4 8 10
//        5 7 11 14
//        1 1
//        2 4
//        2 4
//Sample output 2:
//        2 4


public class TwoIntervalsIntersection {

        public static ArrayList<ArrayList<Integer>> intersectionIntervals(ArrayList<ArrayList<Integer>> interval1, ArrayList<ArrayList<Integer>> interval2, int n1, int n2) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            int i = 0, j = 0; // Pointers for both interval lists

            while (i < n1 && j < n2) {
                // Extract the intervals
                int start1 = interval1.get(i).get(0);
                int end1 = interval1.get(i).get(1);
                int start2 = interval2.get(j).get(0);
                int end2 = interval2.get(j).get(1);

                // Find intersection if it exists
                int intersectionStart = Math.max(start1, start2);
                int intersectionEnd = Math.min(end1, end2);

                // Check if the intervals overlap
                if (intersectionStart <= intersectionEnd) {
                    ArrayList<Integer> intersection = new ArrayList<>();
                    intersection.add(intersectionStart);
                    intersection.add(intersectionEnd);
                    result.add(intersection);
                }

                // Move the pointer of the interval with the smaller end
                if (end1 < end2) {
                    i++;
                } else {
                    j++;
                }
            }

            return result;
        }

        public static void main(String[] args) {
            // Example usage
            ArrayList<ArrayList<Integer>> interval1 = new ArrayList<>();
            interval1.add(new ArrayList<>(Arrays.asList(1, 3)));
            interval1.add(new ArrayList<>(Arrays.asList(5, 7)));
            interval1.add(new ArrayList<>(Arrays.asList(9, 12)));

            ArrayList<ArrayList<Integer>> interval2 = new ArrayList<>();
            interval2.add(new ArrayList<>(Arrays.asList(2, 6)));
            interval2.add(new ArrayList<>(Arrays.asList(8, 10)));
            interval2.add(new ArrayList<>(Arrays.asList(11, 15)));

            int n1 = interval1.size();
            int n2 = interval2.size();

            ArrayList<ArrayList<Integer>> intersection = intersectionIntervals(interval1, interval2, n1, n2);
            System.out.println(intersection);  // Output: [[2
        }
    }

