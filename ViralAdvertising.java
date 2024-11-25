public class ViralAdvertising {
    public static int viralAdvertising(int n) {
        int peopleReached = 5;   // Starting people reached on day 1
        int cumulativeLikes = 0; // Total number of likes

        for (int day = 1; day <= n; day++) {
            int likes = peopleReached / 2;   // People who like the ad (half of people reached)
            cumulativeLikes += likes;        // Add to the cumulative likes
            peopleReached = likes * 3;       // New people reached are 3 times the number of likes
        }

        return cumulativeLikes;  // Return the total number of likes after n days
    }

    public static void main(String[] args) {
        int n = 3;  // Example input
        int result = viralAdvertising(n); // Call the function
        System.out.println(result);  // Output: 9
    }
}
