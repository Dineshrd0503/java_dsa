package strings;

/*
Problem Statement:
You are given a string ‘str’ of size ‘N’. Your task is to remove consecutive duplicates from this string recursively.

For example:
If the input string is ‘str’ = "aazbbby", then your output will be "azby".
Note that we are just removing adjacent duplicates.

Input Format:
- The first line of input contains an integer 'T' representing the number of test cases.
- The first line of each test case contains a single integer ‘N’ denoting the size of the given string.
- The second line of each test case contains a string of size ‘N’.

Output Format:
- For each test case, print the new string that doesn’t have consecutive duplicates.

Sample Input:
2
7
aazbbby
6
aabbcb

Sample Output:
azby
abcb
*/
/*
Problem Statement:
You are given a string ‘str’ of size ‘N’. Your task is to remove consecutive duplicates from this string recursively.

For example:
If the input string is ‘str’ = "aazbbby", then your output will be "azby".
Note that we are just removing adjacent duplicates.

Input Format:
- The first line of input contains an integer 'T' representing the number of test cases.
- The first line of each test case contains a single integer ‘N’ denoting the size of the given string.
- The second line of each test case contains a string of size ‘N’.

Output Format:
- For each test case, print the new string that doesn’t have consecutive duplicates.

Sample Input:
2
7
aazbbby
6
aabbcb

Sample Output:
azby
abcb
*/

public class RemoveConsecutiveDuplicatesRecursion {

    public static String removeConsecutiveDuplicates(String s) {
        // Base case: if string is empty or has one character
        if (s.length() <= 1) {
            return s;
        }

        // If the first character is the same as the second character
        if (s.charAt(0) == s.charAt(1)) {
            // Skip the first character and call the method on the rest of the string
            return removeConsecutiveDuplicates(s.substring(1));
        } else {
            // Keep the first character and proceed recursively on the remaining string
            return s.charAt(0) + removeConsecutiveDuplicates(s.substring(1));
        }
    }

    public static void main(String[] args) {
        // Predefined test cases
        String[] testStrings = {
                "aazbbby",
                "aabbcb",
                "abcde",
                "aaaaa",
                "abbbaaac"
        };

        // Number of test cases
        int T = testStrings.length;

        // Process each test string
        for (int i = 0; i < T; i++) {
            String str = testStrings[i]; // Actual string

            // Output the results
            System.out.println(removeConsecutiveDuplicates(str));
        }
    }
}
