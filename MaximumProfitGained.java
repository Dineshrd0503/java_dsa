public class MaximumProfitGained {

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxSpent = -1;  // Initialize with -1 to indicate if no valid combination is found

        // Loop through each keyboard
        for (int k : keyboards) {
            // Loop through each USB drive
            for (int d : drives) {
                int totalCost = k + d;

                // Check if the total cost is within the budget
                if (totalCost <= b) {
                    // Update maxSpent if we found a more expensive valid combination
                    maxSpent = Math.max(maxSpent, totalCost);
                }
            }
        }

        // Return the maximum valid combination, or -1 if none found
        return maxSpent;
    }

    public static void main(String[] args) {
        // Example input
        int b = 6;  // Budget
        int[] keyboards = {40, 50, 60};  // Prices of keyboards
        int[] drives = {5, 8, 12};  // Prices of USB drives

        // Get the result
        int moneySpent = getMoneySpent(keyboards, drives, b);

        // Output the result
        System.out.println("The most expensive combination within budget: " + moneySpent);
    }
}
