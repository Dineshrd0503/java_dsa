package codingninjas;

package strings;

///Problem statement
//You are given a string ‘S’ consisting of alphanumeric characters, the string divided into groups by a ‘-’. Your task is to reformat the string that all the groups contain exactly ‘K’ characters. All the lowercase characters should be converted to uppercase.
//
//        Note:
//The first group may have fewer characters than ‘K’.
//For example:
//You are given ‘S’ =’A1-ijklmno-pqr’ and k = ‘3’, then the string contains 3 parts, [“A1”, “ijklmno”, “pqr”], then you can form the string in groups ["A1I”, “JKL”, “MNO”, “PQR"] of uppercase characters. Hence the answer is "A1I-JKL-MNO-PQR"
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= K <= 10^8
//        1 <= |S| <= 10^8
//
//All characters in ‘S’ are alphanumeric and ‘-’.
//
//Time Limit: 1 sec
//Note:
//You do not need to print anything. It has already been taken care of. Just implement the function.
//Sample Input 1:
//        2
//        3
//Ab-ijklmno-pqr
//4
//Isa-dkj
//Sample Output 1:
//ABI-JKL-MNO-PQR
//IS-ADKJ
//Explanation:
//For the first test case ‘S’ = ’Ab-ijklmno-pqr’ and ‘K’ = ‘3’, then the string contains 3 groups, [“Ab”, “ijklmno”, “pqr”], then you can form the string in groups ["ABI”, “JKL”, “MNO”, “PQR"] of uppercase characters. Hence the answer is "ABI-JKL-MNO-PQR".
//
//For the second test case ‘S’ = “Isa-dkj” and ‘K’ = ‘4’, then the string contains 2 groups, [“Isa”, “dkj”], then you can form the string in groups ["IS”, “ADKJ”] of uppercase characters. Hence the answer is "IS-ADKJ".
//Sample Input 2:
//        2
//        2
//a-b-1
//        1
//abcdef
//Sample Output 2:
//A-B1
//A-B-C-D-E-F



public class DivideStringToGroupsWithHypen {

    public static void main(String[] args) {
        // Test cases
        String s1 = "Ab-ijklmno-pqr";
        int k1 = 3;
        System.out.println(stringReformat(s1, k1));  // Expected: "ABI-JKL-MNO-PQR"

        String s2 = "Isa-dkj";
        int k2 = 4;
        System.out.println(stringReformat(s2, k2));  // Expected: "IS-ADKJ"
        
        String s3 = "a-b-1";
        int k3 = 2;
        System.out.println(stringReformat(s3, k3));  // Expected: "A-B1"
        
        String s4 = "abcdef";
        int k4 = 1;
        System.out.println(stringReformat(s4, k4));  // Expected: "A-B-C-D-E-F"
    }

    public static String stringReformat(String s, int k) {
        // Step 1: Remove hyphens and convert characters to uppercase
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
            }
        }

        // Step 2: Get the length of the cleaned string
        int length = sb.length();
        StringBuilder result = new StringBuilder();

        // Step 3: Handle the first group (it might be smaller than k)
        int firstGroupLength = length % k == 0 ? k : length % k;
        result.append(sb.substring(0, firstGroupLength));

        // Step 4: Process remaining groups
        for (int i = firstGroupLength; i < length; i += k) {
            result.append("-");  // Add the hyphen before appending the next group
            result.append(sb.substring(i, Math.min(i + k, length)));
        }

        return result.toString();
    }
}
