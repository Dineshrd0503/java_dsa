package heap;

/*
Problem Statement:
Minimum Steps to Halve Sum

Given an array arr[], find the minimum number of operations required to make the sum of its elements less than or equal to half of the original sum. In one operation, you may replace any element with half of its value (with floating-point precision).

Examples:

Input: arr[] = [8, 6, 2]
Output: 3
Explanation:
Initial sum = 16, half = 8
Halve 8 → arr[] = [4, 6, 2], sum = 12
Halve 6 → arr[] = [4, 3, 2], sum = 9
Halve 2 → arr[] = [4, 3, 1], sum = 8 (done)

Input: arr[] = [9, 1, 2]
Output: 2
Explanation:
Initial sum = 12, half = 6
Halve 9 → arr[] = [4.5, 1, 2], sum = 7.5
Halve 4.5 → arr[] = [2.25, 1, 2], sum = 5.25 (done)

Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^4
*/

import java.util.PriorityQueue;
import java.util.Collections;

// Class name as per GeeksforGeeks problem: Solution
public class MinimumStepsToHalveSum {
    public int minOperations(int[] arr) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for (int val : arr) {
            sum += val;
            maxHeap.add((double) val);
        }
        double target = sum / 2.0;
        int opCount = 0;
        double currSum = sum;

        while (currSum > target) {
            double largest = maxHeap.poll();
            currSum -= largest;
            double halved = largest / 2.0;
            currSum += halved;
            maxHeap.add(halved);
            opCount++;
        }
        return opCount;
    }

    // Sample Test Cases for your main method:

    public static void main(String[] args) {
        MinimumStepsToHalveSum sol = new MinimumStepsToHalveSum();

        int[] test1 = {8, 6, 2};
        System.out.println(sol.minOperations(test1)); // Output: 3

        int[] test2 = {9, 1, 2};
        System.out.println(sol.minOperations(test2)); // Output: 2


    }

}

