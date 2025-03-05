package strings;

//Ninja has been given a program to do basic string compression. For a character that is consecutively repeated more than once, he needs to replace the consecutive duplicate occurrences with the count of repetitions.
//
//Example:
//
//If a string has 'x' repeated 5 times, replace this "xxxxx" with "x5".
//
//The string is compressed only when the repeated character count is more than 1.
//Note :
//
//The consecutive count of every character in the input string is less than or equal to 9.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 5
//        1 <= |S| <= 5000
//
//Where |S| is the size of the string.
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//aaabbddccc
//        ggttttffffrreee
//Sample Output 1:
//a3b2d2c3
//        g2t4f4r2e3
//Explanation of Sample Input 1:
//Test case 1:
//For the first test case of sample output 1, our compressed string is “a3b2d2c3”. It represents that the string contains 3 consecutive ‘a’, 2 consecutive ‘b’, 2 consecutive ‘d’, and 3 consecutive ‘c’.
//Sample Input 2:
//        1
//xyzzz
//Sample Output 2:
//xyz3
//Explanation of Sample Input 2:
//Test case 1:
//For the first test case of sample output 2, our compressed string is ‘xyz3’. As the occurrence of ‘x’ and ‘y’ is 1, hence we do not need to add the count of their repetitions. For the last character ‘z’, we have 3 repetitions.


public class CompressedString {
    public static String compressTheString(String s) {
        // Write your code here
        StringBuilder sb=new StringBuilder();


        for(int i=0;i<s.length();i++){
            char currchar=s.charAt(i);
            int count=1;
            while(i+1<s.length()&&s.charAt(i+1)==currchar){
                count++;
                i++;
            }
            sb.append(currchar);
            if(count>1)
                sb.append(count);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("compressed string");
        System.out.println(compressTheString("aaabbccdeee"));
    }



}
