public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        // Initialize variables to track altitude and number of valleys
        int altitude = 0;
        int valleys = 0;

        // Convert the path into a character array
        char[] moves = path.toCharArray();

        // Traverse through each step in the path
        for (char move : moves) {
            // Check if we are at sea level and the next step is down (start of a valley)
            if (altitude == 0 && move == 'D') {
                valleys++; // Increment the valley count
            }

            // Update the altitude based on the move (U = up, D = down)
            if (move == 'U') {
                altitude++; // Going up increases altitude
            } else if (move == 'D') {
                altitude--; // Going down decreases altitude
            }
        }

        // Return the total number of valleys traversed
        return valleys;
    }

    public static void main(String[] args) {
        // Example test case
        String path = "UDDDUDUU";
        int steps = path.length();
        int result = countingValleys(steps, path);
        System.out.println("Number of valleys traversed: " + result);
    }
}
