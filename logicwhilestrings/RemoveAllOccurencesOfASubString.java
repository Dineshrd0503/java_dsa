package logicwhilestrings;

public class RemoveAllOccurencesOfASubString {

    public static void main(String[] args) {
        String mainStr = "abcabcabc";
        String subStr = "abc";
        String result = removeOccurrences(mainStr, subStr);

        System.out.println("Original String: \"" + mainStr + "\"");
        System.out.println("Substring to Remove: \"" + subStr + "\"");
        System.out.println("Result: \"" + result + "\""); // Expected: ""

        // A more complex example
        String mainStr2 = "daabcbaabcbc";
        String subStr2 = "abc";
        String result2 = removeOccurrences(mainStr2, subStr2);
        System.out.println("\nResult for \"" + mainStr2 + "\": \"" + result2 + "\""); // Expected: "daba"
    }

    /**
     * Removes all occurrences of a substring ('part') from a string ('s').
     * This method uses a StringBuilder in a stack-like manner to build the result.
     *
     * @param s    The original string.
     * @param part The substring to remove.
     * @return A new string with all occurrences of 'part' removed.
     */
    public static String removeOccurrences(String s, String part) {
        if (s == null || part == null || part.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int partLength = part.length();

        // Iterate through each character of the original string.
        for (char currentChar : s.toCharArray()) {
            // 1. Append the current character to our result.
            sb.append(currentChar);

            // 2. Check if the end of our result now matches the substring.
            // We only need to check if our result is long enough.
            if (sb.length() >= partLength && sb.substring(sb.length() - partLength).equals(part)) {

                // 3. If it matches, delete that part from the end of our result.
                sb.delete(sb.length() - partLength, sb.length());
            }
        }

        return sb.toString();
    }
}