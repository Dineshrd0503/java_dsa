package graphs;

/**
 * Problem Statement:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
 * take course bi first if you want to take course ai. Return true if you can finish all courses.
 * Otherwise, return false.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 *
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */

import java.util.*;

public class CourseSchedulingUsingBFS {

    /**
     * Determines if all courses can be finished given their prerequisites.
     *
     * @param numCourses    Total number of courses.
     * @param prerequisites List of prerequisite pairs where prerequisites[i] = [ai, bi].
     * @return true if all courses can be finished, false otherwise.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list and in-degree array
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];
            adj.get(prerequisite).add(course); // Directed edge: prerequisite → course
            inDegree[course]++;
        }

        // Step 2: Initialize queue with courses having zero in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: Perform BFS (Kahn's Algorithm)
        int processed = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processed++;
            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Check if all courses were processed
        return processed == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedulingUsingBFS scheduler = new CourseSchedulingUsingBFS();

        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Example 1 Output: " + scheduler.canFinish(numCourses1, prerequisites1)); // true

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Example 2 Output: " + scheduler.canFinish(numCourses2, prerequisites2)); // false

        // Additional Test Case 1
        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Test Case 3 Output: " + scheduler.canFinish(numCourses3, prerequisites3)); // true

        // Additional Test Case 2
        int numCourses4 = 3;
        int[][] prerequisites4 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Test Case 4 Output: " + scheduler.canFinish(numCourses4, prerequisites4)); // false
    }
}

