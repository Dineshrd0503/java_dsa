package twopointer;

/**
 * ====================================================================
 * Problem Statement: The Celebrity Problem
 * ====================================================================
 *
 * In a party of N people, only one person is known to everyone. Such a person is
 * called a "celebrity". A celebrity is a person who knows no one but is known by
 * everyone else.
 *
 * You are given a square matrix mat[][] of size N x N, where mat[i][j] = 1
 * means person 'i' knows person 'j', and mat[i][j] = 0 means person 'i'
 * does not know person 'j'.
 *
 * Your task is to find the celebrity at the party. If there is no celebrity, return -1.
 *
 * ====================================================================
 * Rules for a Celebrity (let's say person 'c'):
 * ====================================================================
 * 1. For all i from 0 to N-1 (where i != c), mat[c][i] must be 0 (Celebrity knows no one).
 * 2. For all i from 0 to N-1 (where i != c), mat[i][c] must be 1 (Everyone knows the celebrity).
 *
 * ====================================================================
 * Sample Test Cases
 * ====================================================================
 *
 * Example 1:
 * Input:
 * mat[][] = {{0, 1, 0},
 * {0, 0, 0},
 * {0, 1, 0}}
 * Output: 1
 * Explanation: Person 1 knows no one, and everyone (person 0 and 2) knows person 1.
 *
 * Example 2:
 * Input:
 * mat[][] = {{0, 1},
 * {1, 0}}
 * Output: -1
 * Explanation: Person 0 knows 1, and Person 1 knows 0. No one fits the definition
 * of a celebrity.
 */
public class CelebrityProblem {

    /**
     * Finds the celebrity in a party of N people.
     * This optimal solution uses a two-pointer approach to first eliminate all but one
     * candidate and then verifies if that candidate is truly a celebrity.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param relationshipMatrix A 2D array where mat[i][j] = 1 if i knows j.
     * @return The ID of the celebrity (0 to N-1), or -1 if none exists.
     */
    public int findCelebrity(int[][] relationshipMatrix) {
        int numberOfPeople = relationshipMatrix.length;
        if (numberOfPeople < 2) {
            return -1; // A celebrity needs at least one other person to be known by.
        }

        // --- Phase 1: Elimination ---
        // Use two pointers to eliminate non-celebrity candidates.
        int personA = 0;
        int personB = numberOfPeople - 1;

        while (personA < personB) {
            // Check if personA knows personB
            if (relationshipMatrix[personA][personB] == 1) {
                // If personA knows personB, then personA cannot be a celebrity.
                // We eliminate personA and move to the next candidate.
                personA++;
            } else {
                // If personA does not know personB, then personB cannot be a celebrity
                // (because everyone must know a celebrity).
                // We eliminate personB.
                personB--;
            }
        }

        // The person at index 'personA' is our only possible candidate.
        int candidate = personA;

        // --- Phase 2: Verification ---
        // We must verify that our candidate is actually a celebrity.
        for (int i = 0; i < numberOfPeople; i++) {
            // Skip checking the candidate against themselves.
            if (i != candidate) {
                // Check the two conditions for being a celebrity:
                // 1. The candidate must not know person 'i'. (mat[candidate][i] == 0)
                // 2. Person 'i' must know the candidate. (mat[i][candidate] == 1)
                // If either of these is violated, the candidate is not a celebrity.
                boolean candidateKnowsSomeone = (relationshipMatrix[candidate][i] == 1);
                boolean someoneDoesNotKnowCandidate = (relationshipMatrix[i][candidate] == 0);

                if (candidateKnowsSomeone || someoneDoesNotKnowCandidate) {
                    return -1; // Verification failed.
                }
            }
        }

        // If the candidate passes all checks, they are the celebrity.
        return candidate;
    }

    // Main method to test the function with static inputs.
    public static void main(String[] args) {
        CelebrityProblem solution = new CelebrityProblem();

        // Test Case 1: A celebrity exists (person 1)
        System.out.println("--- Test Case 1: Celebrity Exists ---");
        int[][] party1 = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };
        int celebrityId1 = solution.findCelebrity(party1);
        if (celebrityId1 == -1) {
            System.out.println("Result: No celebrity found.");
        } else {
            System.out.println("Result: Person " + celebrityId1 + " is the celebrity."); // Expected: 1
        }
        System.out.println("-------------------------------------\n");


        // Test Case 2: No celebrity exists
        System.out.println("--- Test Case 2: No Celebrity ---");
        int[][] party2 = {
                {0, 1},
                {1, 0}
        };
        int celebrityId2 = solution.findCelebrity(party2);
        if (celebrityId2 == -1) {
            System.out.println("Result: No celebrity found."); // Expected: -1
        } else {
            System.out.println("Result: Person " + celebrityId2 + " is the celebrity.");
        }
        System.out.println("-------------------------------------\n");
    }
}
