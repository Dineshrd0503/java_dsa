package strings;

/*
PROBLEM STATEMENT:
-------------------
Given a keyboard layout as a string 'keyboard' of 26 lowercase English letters (unique order),
and a message string 's' consisting of only lowercase letters,
calculate the total time taken to type the message starting from the first key of the keyboard.
For each character in the message, the time taken is the absolute difference between the index
of the current character in 'keyboard' and the index of the previous character typed.
You start at index 0 (first key of the keyboard).
Return the total time taken.
*/

import java.util.*;

public class MailingProblem {
    public static int timeTakenToMail(String keyboard, String s) {
        int[] pos = new int[26];
        // Map each character to its position on the keyboard
        for (int i = 0; i < 26; i++) {
            pos[keyboard.charAt(i) - 'a'] = i;
        }
        int total = 0;
        int currentIndex = 0;
        for (char c : s.toCharArray()) {
            int targetIndex = pos[c - 'a'];
            total += Math.abs(targetIndex - currentIndex);
            currentIndex = targetIndex;
        }
        return total;
    }

    public static void main(String[] args) {
        // Sample input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter keyboard layout (26 lowercase letters):");
        String keyboard = sc.next();

        System.out.println("Enter message string:");
        String message = sc.next();

        // Calculate the time
        int result = timeTakenToMail(keyboard, message);
        System.out.println("Total time taken: " + result);
    }
}
