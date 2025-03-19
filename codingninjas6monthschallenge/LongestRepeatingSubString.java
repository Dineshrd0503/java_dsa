package codingninjas6monthschallenge;


//Problem statement
//You are given a string 'str' of length 'N'. You can perform at most 'k' operations on this string. In one operation, you can choose any character of the string and change it to any other uppercase English alphabet character.
//
//
//
//Return the length of the longest substring containing same characters after performing the above operations.
//
//
//
//For example :

//Input:
//str="AABC"  k=1
//
//Output:3
//
//Explanation: Replace 'B' with 'A', we will get "AAAC" and the longest substring with same character is "AAA" of length 3.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//ABCCAA
//2
//Sample Output 1 :
//        4
//Explanation for Sample Input 1 :
//        “AAAA” and “CCCC” are the longest repeating substring we can get after performing 2 operations.
//Sample Input 2 :
//ABA
//3
//Sample Output 2 :
//        3
//Constraints :
//        1 <= |s| <= 10^5
//        0 <= k <= |s|
//        's' consists of only uppercase English letters.
//
//
//where |s| is the length of the given string.
//
//Time Limit: 1sec



public class LongestRepeatingSubString {
    public static int longestRepeatingSubstring(String str, int k) {
        // Write your code here.
        int[] freq = new int[26];
        int left = 0, maxfreq = 0, result = 0;
        for (int right = 0; right < str.length(); right++) {
            char currchar = str.charAt(right);
            if (currchar < 'A' || currchar > 'Z') {
                throw new IllegalArgumentException("Input string must contain only uppercase English letters.");
            }
            freq[currchar - 'A']++;
            maxfreq = Math.max(maxfreq, freq[currchar - 'A']);
            while (right - left + 1 - maxfreq > k) {
                freq[str.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Finding the longest repeating substring");
        String str = "AABC";
        System.out.println(longestRepeatingSubstring(str, 1)); // Expected output: 3
    }
}