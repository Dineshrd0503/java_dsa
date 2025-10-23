package heap;


/*
Problem Statement:
Given an array of points where each point is represented as [x, y] (on a 2D plane),
and an integer k, return the k closest points to the origin (0, 0).

The distance of a point (x, y) from the origin is sqrt(x^2 + y^2).
You must use squared distance for optimal comparison.

Example Input:
points = [[1, 3], [-2, 2], [5, 8], [0, 1]]
k = 2

Expected Output (any order):
[-2, 2]
[0, 1]
*/

import java.util.*;

public  class kClosestPointsToOrigin {
    // Returns k closest points to origin
    public List<int[]> kClosest(int[][] points, int k) {
        // Max Heap by distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                Integer.compare(distance(b), distance(a))
        );
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove farthest when > k
            }
        }
        List<int[]> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }
        return result;
    }

    // Squared Euclidean distance from origin
    private int distance(int[] pt) {
        return pt[0] * pt[0] + pt[1] * pt[1];
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        kClosestPointsToOrigin solution = new kClosestPointsToOrigin();
        List<int[]> closest = solution.kClosest(points, k);

        System.out.println("K Closest points to origin:");
        for (int[] pt : closest) {
            System.out.println(Arrays.toString(pt));
        }
    }
}
