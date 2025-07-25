package logicwhilecollections;

import java.util.HashSet;

public class JewelsAndStones {

    /**
     * Problem: Jewels and Stones
     *
     * You're given strings jewels representing the types of stones that are jewels,
     * and stones representing the stones you have. Each character in stones is a type of stone you have.
     * You want to know how many of the stones you have are also jewels.
     *
     * Letters are case sensitive, so "a" is considered a different type of stone from "A".
     *
     * Example:
     * Input: jewels = "aA", stones = "aAAbbbb"
     * Output: 3
     *
     * Constraints:
     * - 1 <= jewels.length, stones.length <= 50
     * - jewels and stones consist of only English letters
     */

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();

        for (char c : jewels.toCharArray()) {
            set.add(c);
        }

        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones solution = new JewelsAndStones();
        // Test case 1
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        int result1 = solution.numJewelsInStones(jewels1, stones1);
        System.out.println("Test case 1 - Jewels count: " + result1);  // Expected: 3

        // Test case 2
        String jewels2 = "z";
        String stones2 = "ZZZz";
        int result2 = solution.numJewelsInStones(jewels2, stones2);
        System.out.println("Test case 2 - Jewels count: " + result2);  // Expected: 1
    }
}
