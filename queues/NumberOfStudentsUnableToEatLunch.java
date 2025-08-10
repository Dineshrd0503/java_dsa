package queues;

/*
LeetCode 1700: Number of Students Unable to Eat Lunch

The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.

The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
- If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
- Otherwise, they will leave it and go to the queue's end.
This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

Given two integer arrays students and sandwiches where sandwiches[i] is the type of the i-th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j-th student in the initial queue (j = 0 is the front of the queue), return the number of students that are unable to eat.

Constraints:
- 1 <= students.length, sandwiches.length <= 100
- students.length == sandwiches.length
- sandwiches[i] is 0 or 1
- students[i] is 0 or 1

Example 1:
Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0
Explanation: All students get sandwiches after some reordering.

Example 2:
Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3
Explanation: Three students preferring square sandwiches cannot eat.

Example 3:
Input: students = [1], sandwiches = [0]
Output: 1
Explanation: Single student cannot take the sandwich.

Example 4:
Input: students = [0,0,0], sandwiches = [0,0,0]
Output: 0
Explanation: All students take matching sandwiches.
*/

public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        // Count students preferring circular (0) and square (1) sandwiches
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }

        // Process sandwiches
        for (int sandwich : sandwiches) {
            // If no student prefers this sandwich, return remaining students
            if (count[sandwich] == 0) {
                return count[0] + count[1];
            }
            // Student takes sandwich, decrement count
            count[sandwich]--;
        }

        // All sandwiches taken, no students remain
        return 0;
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch solution = new NumberOfStudentsUnableToEatLunch();

        // Test Case 1: students = [1,1,0,0], sandwiches = [0,1,0,1]
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        System.out.println("Test Case 1: " + solution.countStudents(students1, sandwiches1)); // Expected: 0

        // Test Case 2: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
        System.out.println("Test Case 2: " + solution.countStudents(students2, sandwiches2)); // Expected: 3

        // Test Case 3: students = [1], sandwiches = [0]
        int[] students3 = {1};
        int[] sandwiches3 = {0};
        System.out.println("Test Case 3: " + solution.countStudents(students3, sandwiches3)); // Expected: 1

        // Test Case 4: students = [0,0,0], sandwiches = [0,0,0]
        int[] students4 = {0, 0, 0};
        int[] sandwiches4 = {0, 0, 0};
        System.out.println("Test Case 4: " + solution.countStudents(students4, sandwiches4)); // Expected: 0
    }
}