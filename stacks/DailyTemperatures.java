package stacks;

/*
Given an array of integers temperatures represents
the daily temperatures, return an array answer such t
hat answer[i] is the number of days you have
 to wait after the ith day to get a warmer
 temperature. If there is no future day for which
 this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]

 */



public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n]; // Initialize answer array with 0s
        java.util.Stack<Integer> stack = new java.util.Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current temperature is warmer than
            // the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int top = stack.pop(); // Get the index of the day from the top of the stack
                answer[top] = i - top;  // Calculate the waiting days
            }
            stack.push(i); // Push the current day's index onto the stack
        }

        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);

        // Print the result
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // Output: [1, 1, 4, 2, 1, 1, 0, 0]

        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = solution.dailyTemperatures(temperatures2);

        System.out.print("[");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");  // Output: [1, 1, 1, 0]

        int[] temperatures3 = {30, 60, 90};
        int[] result3 = solution.dailyTemperatures(temperatures3);

        System.out.print("[");
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i]);
            if (i < result3.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");  // Output: [1, 1, 0]
    }
}