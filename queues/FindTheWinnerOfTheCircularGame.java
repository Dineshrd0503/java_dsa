package queues;
public class FindTheWinnerOfTheCircularGame {
    /**
     * 1823. Find the Winner of the Circular Game
     *
     * There are `n` friends that are playing a game. The friends are sitting in a circle and are numbered from `1` to `n` in **clockwise order**. More formally, moving clockwise from the `ith` friend brings you to the `(i+1)th` friend for `1 <= i < n`, and moving clockwise from the `nth` friend brings you to the `1st` friend.
     *
     * The rules of the game are as follows:
     *
     * 1.  **Start** at the `1st` friend.
     * 2.  Count the next `k` friends in the clockwise direction **including** the friend you started at. The counting wraps around the circle and may count some friends more than once.
     * 3.  The last friend you counted leaves the circle and loses the game.
     * 4.  If there is still more than one friend in the circle, go back to step `2` **starting** from the friend **immediately clockwise** of the friend who just lost and repeat.
     * 5.  Else, the last friend in the circle wins the game.
     *
     * Given the number of friends, `n`, and an integer `k`, return _the winner of the game_.
     *
     *
     *
     * Example 1:
     *
     * ![](https://assets.leetcode.com/uploads/2021/03/25/ic234-q2-ex11.png)
     *
     * Input: n = 5, k = 2
     * Output: 3
     * Explanation: Here are the steps of the game:
     * 1) Start at friend 1.
     * 2) Count 2 friends clockwise, which are friends 1 and 2.
     * 3) Friend 2 leaves the circle. Next start is friend 3.
     * 4) Count 2 friends clockwise, which are friends 3 and 4.
     * 5) Friend 4 leaves the circle. Next start is friend 5.
     * 6) Count 2 friends clockwise, which are friends 5 and 1.
     * 7) Friend 1 leaves the circle. Next start is friend 3.
     * 8) Count 2 friends clockwise, which are friends 3 and 5.
     * 9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.
     *
     * Example 2:
     *
     * Input: n = 6, k = 5
     * Output: 1
     * Explanation: The friends leave in this order: 5, 4, 6, 2, 3. The winner is friend 1.
     * @param n The number of friends.
     * @param k The counting step.
     * @return The winner's number.
     */
    public int findTheWinner(int n, int k) {
        int winner = 0; // Winner's index (0-based) for n = 1

        // Iterate from 2 to n, building the solution iteratively
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        //The problem asks for 1-based numbering, not 0-based indexing so we add 1
        return winner + 1;
    }

    public static void main(String[] args) {
        FindTheWinnerOfTheCircularGame solution= new FindTheWinnerOfTheCircularGame();
        int n1 = 5, k1 = 2;
        System.out.println("Winner for n=" + n1 + ", k=" + k1 + ": " + solution.findTheWinner(n1, k1)); // Expected: 3

        int n2 = 6, k2 = 5;
        System.out.println("Winner for n=" + n2 + ", k=" + k2 + ": " + solution.findTheWinner(n2, k2)); // Expected: 1

        int n3 = 7, k3 = 3;
        System.out.println("Winner for n=" + n3 + ", k=" + k3 + ": " + solution.findTheWinner(n3, k3)); // Expected 4

        int n4 = 500, k4 = 500;
        System.out.println("Winner for n=" + n4 + ", k=" + k4 + ": " + solution.findTheWinner(n4, k4)); // Expected 1

        int n5 = 500, k5 =17;
         System.out.println("Winner for n=" + n5 + ", k=" + k5 + ": " + solution.findTheWinner(n5, k5)); // Expected 421
    }
}
