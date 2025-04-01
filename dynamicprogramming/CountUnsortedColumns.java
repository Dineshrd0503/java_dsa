package strings;
// Class to count the number of unsorted columns in an array of strings
public class CountUnsortedColumns {

    /**
     * This method counts the number of columns that are not sorted lexicographically.
     *
     * @param strings An array of strings where each string has the same length
     * @return The number of unsorted columns
     */
    public static int countColumns(String[] strings) {
        // Check for null or empty input
        if (strings == null || strings.length == 0 || strings[0].length() == 0) {
            return 0; // No columns to check
        }

        // Get the number of columns from the length of the first string
        int columnCount = strings[0].length();
        int unsortedColumns = 0; // Counter for unsorted columns

        // Iterate through each column
        for (int col = 0; col < columnCount; col++) {
            // Check if this column is sorted
            for (int row = 1; row < strings.length; row++) {
                // Compare characters in adjacent rows
                if (strings[row].charAt(col) < strings[row - 1].charAt(col)) {
                    unsortedColumns++; // Increment counter if unsorted
                    break; // Move to the next column
                }
            }
        }

        return unsortedColumns; // Return the count of unsorted columns
    }

    public static void main(String[] args) {
        // Example test cases
        String[][] testCases = {
            {"bccde", "dehrt", "gabzy"},
            {"wr", "yz"},
            {"u", "e", "y", "b"},
            {"cterub", "aybsgn"}
        };

        // Process each test case and print results
        for (String[] testCase : testCases) {
            int result = countColumns(testCase);
            System.out.println("Number of unsorted columns: " + result);
        }
    }
}
