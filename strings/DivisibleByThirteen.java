package strings;

/*blem Statement:
Given a number represented as a string s (which may be very large), check whether it is divisible
by 13 or not. Return true if the number is divisible by 13 (i.e., the division results in a whole
number with no remainder), and false otherwise.

Examples:
- Input: s = "2911285" -> Output: true (2911285 / 13 = 223945)
- Input: s = "27" -> Output: false (27 / 13 ≈ 2.0769...)

Constraints:
- 1 ≤ s.size() ≤ 10^5
*/

public class DivisibleByThirteen {
    public boolean isDivisibleByThirteen(String s) {
        // Initialize remainder
        long rem = 0;

        // Process each digit
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            rem = (rem * 10 + digit) % 13;
        }

        // Number is divisible by 13 if remainder is 0
        return rem == 0;
    }

    public static void main(String[] args) {
        DivisibleByThirteen solution = new DivisibleByThirteen();

        // Test Case 1: s = "2911285"
        String s1 = "2911285";
        System.out.println("Test Case 1: s = \"2911285\" -> Output: " + solution.isDivisibleByThirteen(s1));

        // Test Case 2: s = "27"
        String s2 = "27";
        System.out.println("Test Case 2: s = \"27\" -> Output: " + solution.isDivisibleByThirteen(s2));

        // Additional Test Case: s = "0"
        String s3 = "0";
        System.out.println("Test Case 3: s = \"0\" -> Output: " + solution.isDivisibleByThirteen(s3));

        // Additional Test Case: s = "13"
        String s4 = "13";
        System.out.println("Test Case 4: s = \"13\" -> Output: " + solution.isDivisibleByThirteen(s4));
    }
}