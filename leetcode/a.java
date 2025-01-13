package leetcode;

//Given two positive integers n and k, the binary string Sn is formed as follows:

//S1 = "0"
//Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
//Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
//
//        For example, the first four strings in the above sequence are:
//
//S1 = "0"
//S2 = "011"
//S3 = "0111001"
//S4 = "011100110110001"
//Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
//
//
//
//        Example 1:
//
//Input: n = 3, k = 1
//Output: "0"
//Explanation: S3 is "0111001".
//The 1st bit is "0".
//Example 2:
//
//Input: n = 4, k = 11
//Output: "1"
//Explanation: S4 is "011100110110001".
//The 11th bit is "1".

public class a {

    // Function to find the K-th bit in the binary string Sn
    public static char findKthBit(int n, int k) {
        return findKthBitHelper(n, k);
    }

    // Helper function to recursively find the K-th bit
    private static char findKthBitHelper(int n, int k) {
        // Base case: If n == 1, the string is "0"
        if (n == 1) {
            return '0';
        }

        // Length of Sn is 2^n - 1
        int length = (1 << n) - 1;
        int mid = length / 2 + 1;

        if (k == mid) {
            // Middle element is always '1'
            return '1';
        } else if (k < mid) {
            // If k is in the first half, it maps to the same position in Sn-1
            return findKthBitHelper(n - 1, k);
        } else {
            // If k is in the second half, it corresponds to the mirrored and inverted bit
            // The mirrored position in the first half is (length - k + 1)
            char mirroredBit = findKthBitHelper(n - 1, length - k + 1);
            // Invert the mirrored bit
            return mirroredBit == '0' ? '1' : '0';
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {

        // Test cases
        int n1 = 3, k1 = 1;
        int n2 = 4, k2 = 11;

        // Test case 1
        char result1 = findKthBit(n1, k1);
        System.out.println("The " + k1 + "-th bit in S" + n1 + " is: " + result1);

        // Test case 2
        char result2 = findKthBit(n2, k2);
        System.out.println("The " + k2 + "-th bit in S" + n2 + " is: " + result2);
    }
}

