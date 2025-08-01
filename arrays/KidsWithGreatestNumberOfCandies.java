package arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


    /**
     * There are `n` kids with candies. You are given an integer array `candies`,
     * where each `candies[i]` represents the number of candies the `ith` kid has,
     * and an integer `extraCandies`, denoting the number of extra candies that you
     * have.
     *
     * Return _a boolean array_ `result` _of length_ `n`_, where_ `result[i]`
     * _is_ `true` _if, after giving the_ `ith` _kid all the_ `extraCandies`_, they
     * will have the **greatest** number of candies among all the kids__, or_
     * `false` _otherwise_.
     *
     * Note that **multiple** kids can have the **greatest** number of candies.
     *
     * Example 1:
     *
     * Input: candies = [2,3,5,1,3], extraCandies = 3
     * Output: [true,true,true,false,true]
     * Explanation: If you give all extraCandies to:
     * - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the
     * kids.
     * - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the
     * kids.
     * - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the
     * kids.
     * - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among
     * the kids.
     * - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the
     * kids.
     *
     * Example 2:
     *
     * Input: candies = [4,2,1,1,2], extraCandies = 1
     * Output: [true,false,false,false,false]
     * Explanation: There is only 1 extra candy.
     * Kid 1 will always have the greatest number of candies, even if a different
     * kid is given the extra candy.
     *
     * Example 3:
     *
     * Input: candies = [12,1,12], extraCandies = 10
     * Output: [true,false,true]
     *
     * Constraints:
     *
     * n == candies.length
     * 2 <= n <= 100
     * 1 <= candies[i] <= 100
     * 1 <= extraCandies <= 50
    The number of extra candies.
     * @return A boolean array representing whether each kid can have the greatest number of candies.
     */
  public class KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }


    public static void main(String[] args) {
        KidsWithGreatestNumberOfCandies solution = new KidsWithGreatestNumberOfCandies();

        // Example usage
        int[] candies1 = {2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        System.out.println(solution.kidsWithCandies(candies1, extraCandies1)); // Output: [true, true, true, false, true]

        int[] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        System.out.println(solution.kidsWithCandies(candies2, extraCandies2)); // Output: [true, false, false, false, false]

        int[] candies3 = {12, 1, 12};
        int extraCandies3 = 10;
        System.out.println(solution.kidsWithCandies(candies3, extraCandies3)); // Output: [true, false, true]
    }
}
