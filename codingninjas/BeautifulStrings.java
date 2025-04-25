package codingninjas;

/*
Problem Statement:
Ninja has been given a binary string ‘STR’ containing either ‘0’ or ‘1’. A binary string is called beautiful if it contains alternating 0s and 1s.

For Example: ‘0101’, ‘1010’, ‘101’, ‘010’ are beautiful strings.

He wants to make ‘STR’ beautiful by performing some operations on it. In one operation, Ninja can convert ‘0’ into ‘1’ or vice versa.

Your task is to determine the minimum number of operations Ninja should perform to make ‘STR’ beautiful.

Constraints:
1 <= T <= 100
2 <= |STR| <= 10^5
STR[i] = ‘1’ or ‘0’

Where '|STR|' denotes the length of ‘STR’.

Time Limit: 1 sec

Sample Input 1:
2
0000
1010

Sample Output 1:
2
0

Sample Input 2:
2
01011
1001

Sample Output 2:
1
2
*/




public class BeautifulStrings {

    // Function to calculate the minimum operations to make the string beautiful
    public static int minOperationsToMakeBeautiful(String str) {
        int count1 = 0; // Count for pattern "0101..."
        int count2 = 0; // Count for pattern "1010..."

        for (int i = 0; i < str.length(); i++) {
            char expectedChar1 = (i % 2 == 0) ? '0' : '1'; // Pattern "0101..."
            char expectedChar2 = (i % 2 == 0) ? '1' : '0'; // Pattern "1010..."

            if (str.charAt(i) != expectedChar1) {
                count1++;
            }
            if (str.charAt(i) != expectedChar2) {
                count2++;
            }
        }

        return Math.min(count1, count2); // Return the minimum of the two counts
    }

    public static void main(String[] args) {
        // Static test cases
        String[] testCases = {"0000", "1010", "01011", "1001"};

        for (String testCase : testCases) {
            System.out.println(minOperationsToMakeBeautiful(testCase));
        }
    }
}
