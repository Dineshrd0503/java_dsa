package microsofttest;

/**
 * Problem Description:
 * Strings with long blocks of repeating characters take much less space if kept in a compressed representation.
 * To obtain the compressed representation, we replace each segment of equal characters in the string with the
 * number of characters in the segment followed by the character (for example, we replace the segment "CCC" with "3C").
 * To avoid increasing the size, we leave the one-letter segments unchanged (the compressed representation of "BC" is
 * the same string -- "BC").
 *
 * For example, the compressed representation of the string "ABBBCCDDCCC" is "A3B2C2D3C", and the compressed
 * representation of the string "AAAAABXAAAAAAAAAA" is "5ABX10A".
 *
 * Observe that, in the second example, if we removed the "BXX" segment from the middle of the word, we would obtain a
 * much shorter compressed representation -- "14A". In order to take advantage of this observation, we decided to modify
 * our compression algorithm. Now, before compression, we remove exactly K consecutive letters from the input string.
 * We would like to know the shortest compressed form that we can generate this way.
 *
 * Write a function:
 *     int solution(char[] S, int K);
 * that, given a string S of length N and an integer K, returns the shortest possible length of the compressed
 * representation of S after removing exactly K consecutive characters from S.
 *
 * Examples:
 * 1. Given S = "ABBBCCDDCCC" and K = 3, the function should return 5, because after removing "DDC" from S, we are
 *    left with "ABBBCCC", which compresses to a representation of length 5 -- "A3B3C".
 *
 * 2. Given S = "AAAAAAAAAABXXAAAAAAAAAA" and K = 3, the function should return 3, because after removing "BXX" from S,
 *    we are left with "AAAAAAAAAAAAAAAAAA", which compresses to a representation of length 3 -- "21A".
 *
 * 3. Given S = "ABCDDDEFG" and K = 2, the function should return 6, because after removing "EF" from S, we are left
 *    with "ABCDDDG", which compresses to a representation of length 6 -- "ABC3DG".
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1..100,000];
 * - K is an integer within the range [0..100,000];
 * - K <= N;
 * - string S is made only of uppercase letters (A-Z).
 */
public class StringCompressionAfterRemoval {
    // Helper function to compute the compressed length of a segment
    private static int compressedLength(int count) {
        if (count == 0) return 0;
        if (count == 1) return 1; // e.g., "A"
        return String.valueOf(count).length() + 1; // e.g., "10A" -> 3
    }

    public static int solution(char[] S, int K) {
        int N = S.length;
        // Step 1: Convert the string into run-length encoded segments
        int[] counts = new int[N];
        char[] chars = new char[N];
        int segmentCount = 0;
        counts[0] = 1;
        chars[0] = S[0];
        for (int i = 1; i < N; i++) {
            if (S[i] == chars[segmentCount]) {
                counts[segmentCount]++;
            } else {
                segmentCount++;
                chars[segmentCount] = S[i];
                counts[segmentCount] = 1;
            }
        }
        segmentCount++; // Number of segments

        // Step 2: For each possible removal of K consecutive characters
        int minCompressedLength = Integer.MAX_VALUE;
        for (int start = 0; start <= N - K; start++) {
            // Compute the new segments after removing S[start] to S[start + K - 1]
            int[] newCounts = new int[segmentCount + 1];
            char[] newChars = new char[segmentCount + 1];
            int newSegmentCount = 0;

            // Track how many characters we've processed
            int charsProcessed = 0;
            int segmentIdx = 0;

            // Add segments before the removal
            while (segmentIdx < segmentCount && charsProcessed < start) {
                int remaining = start - charsProcessed;
                int take = Math.min(counts[segmentIdx], remaining);
                if (take > 0) {
                    newCounts[newSegmentCount] = take;
                    newChars[newSegmentCount] = chars[segmentIdx];
                    newSegmentCount++;
                }
                charsProcessed += take;
                if (take == counts[segmentIdx]) segmentIdx++;
            }

            // Skip K characters (the removal)
            charsProcessed += K;
            while (segmentIdx < segmentCount && charsProcessed > 0) {
                int skip = Math.min(counts[segmentIdx], charsProcessed - (start + K));
                if (skip == counts[segmentIdx]) {
                    segmentIdx++;
                } else {
                    counts[segmentIdx] -= skip;
                    break;
                }
                charsProcessed -= counts[segmentIdx];
            }

            // Add remaining segments after the removal
            int lastCharIdx = newSegmentCount - 1;
            while (segmentIdx < segmentCount) {
                if (newSegmentCount > 0 && newChars[lastCharIdx] == chars[segmentIdx]) {
                    newCounts[lastCharIdx] += counts[segmentIdx];
                } else {
                    newCounts[newSegmentCount] = counts[segmentIdx];
                    newChars[newSegmentCount] = chars[segmentIdx];
                    newSegmentCount++;
                    lastCharIdx++;
                }
                segmentIdx++;
            }

            // Compute the compressed length of the new string
            int compressedLen = 0;
            for (int i = 0; i < newSegmentCount; i++) {
                compressedLen += compressedLength(newCounts[i]);
            }
            minCompressedLength = Math.min(minCompressedLength, compressedLen);
        }

        return minCompressedLength;
    }

    // Main method to test the solution with the sample test cases
    public static void main(String[] args) {
        // Test Case 1
        char[] S1 = "ABBBCCDDCCC".toCharArray();
        int K1 = 3;
        int expected1 = 5;
        int actual1 = solution(S1, K1);
        System.out.println("Test Case 1:");
        System.out.println("Expected Output: " + expected1);
        System.out.println("Actual Output: " + actual1);
        System.out.println("Result: " + (expected1 == actual1 ? "PASS" : "FAIL"));
        System.out.println();

        // Test Case 2
        char[] S2 = "AAAAAAAAAABXXAAAAAAAAAA".toCharArray();
        int K2 = 3;
        int expected2 = 3;
        int actual2 = solution(S2, K2);
        System.out.println("Test Case 2:");
        System.out.println("Expected Output: " + expected2);
        System.out.println("Actual Output: " + actual2);
        System.out.println("Result: " + (expected2 == actual2 ? "PASS" : "FAIL"));
        System.out.println();

        // Test Case 3
        char[] S3 = "ABCDDDEFG".toCharArray();
        int K3 = 2;
        int expected3 = 6;
        int actual3 = solution(S3, K3);
        System.out.println("Test Case 3:");
        System.out.println("Expected Output: " + expected3);
        System.out.println("Actual Output: " + actual3);
        System.out.println("Result: " + (expected3 == actual3 ? "PASS" : "FAIL"));
    }
}
