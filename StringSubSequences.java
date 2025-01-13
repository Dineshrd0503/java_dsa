public class StringSubSequences {
    public static void main(String[] args) {
        String str = "hello";
        printSubsequences(str,0,"");
    }
    
    public static void printSubsequences(String str,int index,String curr) {
        if (index == str.length()) {
            return;
        }

        // Print the current substring
        System.out.println(curr + str.charAt(index));

        // Recursively generate substrings
        printSubsequences(str, index + 1, curr);
        printSubsequences(str, index + 1, curr + str.charAt(index));

    }
        
        
}
