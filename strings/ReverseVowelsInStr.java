package strings;

//Given a string consisting of lowercase English alphabets, reverse only the vowels present in it and print the resulting string.
//
//        Examples:
//
//Input: s = "geeksforgeeks"
//Output: "geeksforgeeks"
//Explanation: The vowels are: e, e, o, e, e. Reverse of these is also e, e, o, e, e.
//Input: s = "practice"
//Output: "prectica"
//Explanation: The vowels are a, i, e. Reverse of these is e, i, a.
//        Input: s = "bcdfg"
//Output: "bcdfg"
//Explanation: There are no vowels in s.
//Constraints:
//        1<=|s|<=105




public class ReverseVowelsInStr {
    String modify (String s)
    {
        char[] letters=s.toCharArray();
        int left=0,right=letters.length-1;
        while(left<right){
            if (!isvowel(letters[left])) {
                left++;
            } else if (!isvowel(letters[right])) {
                right--;
            } else {
                // Swap vowels
                char temp = letters[left];
                letters[left] = letters[right];
                letters[right] = temp;
                left++;
                right--;
            }

        }
        return  new String(letters);
        // your code here

    }
    private static boolean isvowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
    public static void main(String[] args) {
        ReverseVowelsInStr obj=new ReverseVowelsInStr();
        String s="hello";
        System.out.println(obj.modify(s));
    }
}
