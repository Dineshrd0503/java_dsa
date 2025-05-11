package microsofttest;

/**
 * Problem Description:
 * Given two strings S and T of equal length, representing non-negative integers, you can swap digits at corresponding positions
 * (i.e., S[i] with T[i]) any number of times. The goal is to find the minimum number of swaps needed to make the absolute difference
 * between the numerical values of S and T as small as possible. After swaps, the numbers may have leading zeros.
 *
 * Constraints:
 * - 1 <= S.length = T.length <= 100,000
 * - S and T consist of digits from '0' to '9'
 *
 * Sample Test Cases:
 * 1. S = "29162", T = "10524"
 *    Expected Output: 2 swaps
 *    Explanation: Swap positions 1 (2 ↔ 1) and 3 (6 ↔ 2) to get S = "20122", T = "19564". Difference = |20122 - 19564| = 558, which is minimal.
 *
 * 2. S = "12345", T = "54321"
 *    Expected Output: 1 swap
 *    Explanation: Swap position 1 (2 ↔ 4) to get S = "14345", T = "52321". Difference = |14345 - 52321| = 37976, which is minimal.
 *
 * 3. S = "123", T = "123"
 *    Expected Output: 0 swaps
 *    Explanation: Strings are identical, so no swaps are needed. Difference = 0.
 *
 * 4. S = "5", T = "3"
 *    Expected Output: 1 swap
 *    Explanation: Swap position 0 (5 ↔ 3) to get S = "3", T = "5". Difference = |3 - 5| = 2, which is minimal.
 *
 * 5. S = "9999", T = "1111"
 *    Expected Output: 2 swaps
 *    Explanation: Swap positions 1 and 2 to get S = "1919", T = "9191". Difference = |1919 - 9191| = 6272, which is minimal with 2 swaps.
 */
public class MinDiffSwap {
    public static int solution(String S, String T) {
        int n = S.length();
        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();

        // Precompute position values, digit differences, and differing positions
        long[] positionValues = new long[n];
        int[] priorities = new int[n];
        int[] diffPositions = new int[n];
        int diffCount = 0;
        long pow = 1;
        long valS = 0, valT = 0;
        for (int i = n - 1; i >= 0; i--) {
            positionValues[i] = pow;
            pow *= 10;
            valS = valS * 10 + (sArr[i] - '0');
            valT = valT * 10 + (tArr[i] - '0');
            if (sArr[i] != tArr[i]) {
                priorities[i] = Math.abs((sArr[i] - '0') - (tArr[i] - '0'));
                diffPositions[diffCount++] = i;
            }
        }

        long minDiff = Math.abs(valS - valT);
        boolean[] bestSwaps = new boolean[n];
        int bestSwapCount = 0;

        // Step 1: Find minimum difference using individual swaps
        long tempValS = valS, tempValT = valT;
        for (int idx = 0; idx < diffCount; idx++) {
            int i = diffPositions[idx];
            long positionValue = positionValues[i];
            int digitS = sArr[i] - '0';
            int digitT = tArr[i] - '0';

            tempValS = tempValS - digitS * positionValue + digitT * positionValue;
            tempValT = tempValT - digitT * positionValue + digitS * positionValue;
            minDiff = Math.min(minDiff, Math.abs(tempValS - tempValT));
            tempValS = valS;
            tempValT = valT;
        }

        // Step 2: Build swap configuration (combined with pairing)
        for (int pass = 9; pass >= 0; pass--) {
            for (int idx = 0; idx < diffCount; idx++) {
                int i = diffPositions[idx];
                if (priorities[i] == pass && !bestSwaps[i]) {
                    long positionValue = positionValues[i];
                    int digitS = sArr[i] - '0';
                    int digitT = tArr[i] - '0';

                    char temp = sArr[i];
                    sArr[i] = tArr[i];
                    tArr[i] = temp;
                    valS = valS - digitS * positionValue + digitT * positionValue;
                    valT = valT - digitT * positionValue + digitS * positionValue;

                    long diffAfter = Math.abs(valS - valT);
                    if (diffAfter <= minDiff) {
                        bestSwaps[i] = true;
                        bestSwapCount++;
                    } else {
                        int bestJ = -1, bestPriority = -1;
                        for (int idx2 = 0; idx2 < diffCount; idx2++) {
                            int j = diffPositions[idx2];
                            if (i != j && !bestSwaps[j] && priorities[j] > bestPriority) {
                                bestPriority = priorities[j];
                                bestJ = j;
                            }
                        }

                        if (bestJ != -1) {
                            int j = bestJ;
                            long positionValueJ = positionValues[j];
                            int digitSJ = sArr[j] - '0';
                            int digitTJ = tArr[j] - '0';

                            char temp2 = sArr[j];
                            sArr[j] = tArr[j];
                            tArr[j] = temp2;
                            valS = valS - digitSJ * positionValueJ + digitTJ * positionValueJ;
                            valT = valT - digitTJ * positionValueJ + digitSJ * positionValueJ;

                            long diffAfter2 = Math.abs(valS - valT);
                            if (diffAfter2 <= minDiff) {
                                bestSwaps[i] = true;
                                bestSwaps[j] = true;
                                bestSwapCount += 2;
                            } else {
                                tArr[j] = sArr[j];
                                sArr[j] = temp2;
                                valS = valS - digitTJ * positionValueJ + digitSJ * positionValueJ;
                                valT = valT - digitSJ * positionValueJ + digitTJ * positionValueJ;
                                tArr[i] = sArr[i];
                                sArr[i] = temp;
                                valS = valS - digitT * positionValue + digitS * positionValue;
                                valT = valT - digitS * positionValue + digitT * positionValue;
                            }
                        } else {
                            tArr[i] = sArr[i];
                            sArr[i] = temp;
                            valS = valS - digitT * positionValue + digitS * positionValue;
                            valT = valT - digitS * positionValue + digitT * positionValue;
                        }
                    }
                }
            }
        }

        // Step 3: Minimize swaps
        long finalDiff = Math.abs(valS - valT);
        for (int idx = diffCount - 1; idx >= 0; idx--) {
            int i = diffPositions[idx];
            if (bestSwaps[i]) {
                long positionValue = positionValues[i];
                int digitS = sArr[i] - '0';
                int digitT = tArr[i] - '0';

                char temp = sArr[i];
                sArr[i] = tArr[i];
                tArr[i] = temp;
                valS = valS - digitS * positionValue + digitT * positionValue;
                valT = valT - digitT * positionValue + digitS * positionValue;

                if (Math.abs(valS - valT) <= finalDiff) {
                    bestSwaps[i] = false;
                    bestSwapCount--;
                } else {
                    tArr[i] = sArr[i];
                    sArr[i] = temp;
                    valS = valS - digitT * positionValue + digitS * positionValue;
                    valT = valT - digitS * positionValue + digitT * positionValue;
                }
            }
        }

        return bestSwapCount;
    }

    public static void main(String[] args) {
        // Test case 1: S = "29162", T = "10524", Expected: 2 swaps
        String S1 = "29162";
        String T1 = "10524";
        int result1 = solution(S1, T1);
        System.out.println("Test 1: S = " + S1 + ", T = " + T1 + ", Swaps = " + result1 + " (Expected: 2)");

        // Test case 2: S = "12345", T = "54321", Expected: 1 swap
        String S2 = "12345";
        String T2 = "54321";
        int result2 = solution(S2, T2);
        System.out.println("Test 2: S = " + S2 + ", T = " + T2 + ", Swaps = " + result2 + " (Expected: 1)");

        // Test case 3: S = "123", T = "123", Expected: 0 swaps
        String S3 = "123";
        String T3 = "123";
        int result3 = solution(S3, T3);
        System.out.println("Test 3: S = " + S3 + ", T = " + T3 + ", Swaps = " + result3 + " (Expected: 0)");

        // Test case 4: S = "5", T = "3", Expected: 1 swap
        String S4 = "5";
        String T4 = "3";
        int result4 = solution(S4, T4);
        System.out.println("Test 4: S = " + S4 + ", T = " + T4 + ", Swaps = " + result4 + " (Expected: 1)");

        // Test case 5: S = "9999", T = "1111", Expected: 2 swaps
        String S5 = "9999";
        String T5 = "1111";
        int result5 = solution(S5, T5);
        System.out.println("Test 5: S = " + S5 + ", T = " + T5 + ", Swaps = " + result5 + " (Expected: 2)");
    }
}
