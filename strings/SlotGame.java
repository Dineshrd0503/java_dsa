package strings;

import java.util.*;
import java.io.*;

public class SlotGame {
    /*
    Problem Statement:
    You’re given a slot machine with four slots where each slot will contain the color Red(R), Yellow(Y), Green(G), Blue(B), respectively.
    You don’t know the colors of this slot beforehand. You have to guess the colors.
    When you guess the correct color for the correct slot, you get a perfect hit, and you get 2 points,
    but if you guess a color that exists in the machine but is in the wrong slot, you get a pseudo hit, and you get 1 point.
    You’re given the original string representing the slots’ colors and the guess string,
    and your task is to calculate and return the total number of points you have scored.
    Note: A slot that has been counted as a perfect hit can never count as a pseudo-hit.

    Example:
    Original String = “RGYB” and Guess String = “YGRR”.

    The triangle looks like: (not relevant, but for context)
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above). Wait, ignore - this seems mismatched from problem.

    Actual Samples:
    Sample Input 1:
    1
    RGBY
    GGRR
    Sample Output 1: 3

    Explanation: Second slot matches (G), perfect +2. Two R's in guess, one R in original (not same position), pseudo +1. Total 3.

    Sample Input 2:
    1
    RGYB
    YGRR
    Sample Output 2: 4

    Explanation: Second slot matches (G), perfect +2. Y in guess matches Y in original (wrong pos), +1.
    Two R's in guess, one R in original (wrong pos), +1 (only one pseudo since only one R available). Total 4.

    Constraints:
    1 <= T <= 5
    length(original) = length(guess) = 4

    Dry Run for Sample Input 2 (original="RGYB", guess="YGRR"):
    - original: R G Y B
    - guess:    Y G R R

    Step 1: Perfect hits
    - Pos 0: Y != R
    - Pos 1: G == G -> perfect +=2, mark org[1]='*', dup[1]='#'
    - Pos 2: R != Y
    - Pos 3: R != B
    - Now org: R * Y B
    - dup: Y # R R

    Step 2: Pseudo hits
    - i=0: Y (not '#'), find Y in org at pos 2 -> pseudo +=1, mark org[2]='*'
    - i=1: # (skip)
    - i=2: R (not '#'), find R in org at pos 0 -> pseudo +=1, mark org[0]='*'
    - i=3: R (not '#'), find R in org? No more R (already marked) -> no pseudo
    - Total: perfect 2 + pseudo 2 = 4
    */

    public static int slotScore(String original, String guess) {
        // Write your code here.
        StringBuilder org = new StringBuilder(original);
        StringBuilder dup = new StringBuilder(guess);
        int perfect = 0, pseudo = 0;
        for (int i = 0; i < org.length(); i++) {
            if (org.charAt(i) == dup.charAt(i)) {
                perfect += 2;
                org.setCharAt(i, '*');
                dup.setCharAt(i, '#');
            }
        }
        for (int i = 0; i < org.length(); i++) {
            if (dup.charAt(i) != '#') {
                int idx = org.indexOf(String.valueOf(dup.charAt(i)));
                if (idx != -1) {
                    pseudo++;
                    org.setCharAt(idx, '*');
                }
            }
        }
        return pseudo + perfect;
    }

    public static void main(String[] args) {
        // Sample test cases
        System.out.println(slotScore("RGBY", "GGRR"));  // Output: 3
        System.out.println(slotScore("RGYB", "YGRR"));  // Output: 4
    }
}
