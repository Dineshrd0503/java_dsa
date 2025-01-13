package codingninjas;
//You are given a string ‘str’ of even length. Your task is to find out if we divide the ‘str’ from the middle, will both the substrings contain an equal number of vowels or not.
//
//For Example:
//You are given, ‘str’= ‘codingninjas’, when we split this string we get, ‘coding’ and ‘ninjas’ which both contain 2 vowels each. Hence the answer is ‘True’.
//Sample Input 1:
//        2
//codingninjas
//        helloworld
//Sample Output 2:
//True
//        False
//Explanation:
//For the first test case, ‘str’= ‘codingninjas’, when we split this string we get, ‘coding’ and ‘ninjas’ which both contain 2 vowels each. Hence the answer is ‘True’.
//
//For the second test case, ‘str’= ‘helloworld’, when we split this string we get ‘hello and ‘world’, which contain 2 and 1 vowels respectively. Hence the answer is ‘False’.
//Sample Input 2:
//        2
//Aa
//        AbbaaA
//Sample Output 2:
//True
//        False

public class VowelsInSubStrings {
    public static Boolean splitString(String str) {
        if(str.length()%2!=0)
            return false;
        int mid=str.length()/2;
        String left=str.substring(0,mid);
        String right=str.substring(mid);
        int lvowels=count(left);
        int rvowels=count(right);
        return lvowels==rvowels;

        // Write your code here..
    }
    public static int count(String str){
        int count=0;
        for(char c:str.toLowerCase().toCharArray()){
            if(isvowel(c))
                count++;

        }
        return count;
    }
    public static boolean isvowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(splitString("codingninjas")); // true
        System.out.println(splitString("helloworld")); // false
    }

}
