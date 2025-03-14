package codingninjas7dayschallenge;

import java.util.ArrayList;
import java.util.Arrays;


//You are given an integer ‘NUM’. Your task is to find out two numbers ‘FIRST’ and ‘SECOND’ such that their product is equal to either ‘NUM’ + 1 or ‘NUM’ + 2 and their absolute difference is the minimum between all such pairs.
//
//        Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= ‘T’ <= 10
//        1 <= ‘NUM’ <= 10^8
//
//Time Limit: 1 sec
//Sample Input 1:
//        1
//        10
//Sample Output 1:
//        3 4
//Explanation For Sample Input 1:
//        ‘NUM’ + 1 is equal to 11 for which the answer would be 1 and 11, for ‘NUM’ + 2, which is 12 the answer will be 3 and 4. Hence the better answer is 3 and 4.
//Sample Input 2:
//        1
//        5
//Sample Output 2:
//        2 3


public class ClosestDivisiors {
    public static ArrayList<Integer> closestDivisors(int num) {
        // Write your code here
        int[] candidates = {num + 1, num + 2};
        int bestFirst = 1, bestSecond = num + 1, minDiff = Integer.MAX_VALUE;

        for (int n : candidates) {
            for (int i = (int) Math.sqrt(n); i > 0; i--) {
                if (n % i == 0) {
                    int factor1 = i, factor2 = n / i;
                    int diff = Math.abs(factor1 - factor2);

                    if (diff < minDiff) {
                        minDiff = diff;
                        bestFirst = factor1;
                        bestSecond = factor2;
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(bestFirst, bestSecond));

    }

    public static void main(String[] args) {
        System.out.println("Closest Divisors");
        System.out.println(closestDivisors(8));
    }
}
