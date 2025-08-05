package slidingwindow;
import java.util.HashMap;
import java.util.Map;

/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

 

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
 

Constraints:

*/

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxLength = 0;
        Map<Integer, Integer> fruitCounts = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to the map
            fruitCounts.put(fruits[right], fruitCounts.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 types of fruit, shrink the window
            while (fruitCounts.size() > 2) {
                fruitCounts.put(fruits[left], fruitCounts.get(fruits[left]) - 1); // Decrement count

                if (fruitCounts.get(fruits[left]) == 0) {
                    fruitCounts.remove(fruits[left]); // Remove if count is 0
                }

                left++; // Shrink the window from the left
            }

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
       FruitIntoBaskets solution = new FruitsIntoBaskets();

        // Test cases
        int[] fruits1 = {1, 2, 1};
        System.out.println("Example 1: " + solution.totalFruit(fruits1)); // Output: 3

        int[] fruits2 = {0, 1, 2, 2};
        System.out.println("Example 2: " + solution.totalFruit(fruits2)); // Output: 3

        int[] fruits3 = {1, 2, 3, 2, 2};
        System.out.println("Example 3: " + solution.totalFruit(fruits3)); // Output: 4

        int[] fruits4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 1, 1, 2, 2, 3, 3, 3};
        System.out.println("Example 4: " + solution.totalFruit(fruits4)); // Output: 9
    }
}
