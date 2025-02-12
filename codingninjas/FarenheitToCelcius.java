package codingninjas;
import java.util.*;

//roblem statement
// Ninja has been assigned to convert temperature from Fahrenheit to Celsius. He has been given a starting Fahrenheit Value (S), ending Fahrenheit value (E), and step size (W). Unfortunately, he does not know how to convert from Fahrenheit to Celsius. Please help him to find the result.

// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 5
// 1 <= S <= E <= 10000
// 1 <= W <= 50

// Time limit: 1 sec.
// Sample Input 1:
// 2
// 0 100 20
// 25 50 25
// Sample Output 1:
// 0 -17
// 20 -6
// 40 4
// 60 15
// 80 26
// 100 37
// 25 -3
// 50 10
// Explanation Of Sample Input 1:
// Test case 1:
// For the first test case of sample output 1, we start from Fahrenheit temperature 0 and move up to 100 with a step size of 20 units. For every temperature, we have a corresponding celsius temperature present in the output table.

// Test case 2:   
// For the second test case of sample output 1, we start from Fahrenheit temperature 25 and move up to 50 with a step size of 25 units. For every temperature, we have a corresponding celsius temperature present in the output table.
// Sample Input 2:
// 2
// 50 150 15
// 600 650 7
// Sample Output 2:
// 50 10
// 65 18
// 80 26
// 95 35
// 110 43
// 125 51
// 140 60
// 600 315
// 607 319
// 614 323
// 621 327
// 628 331
// 635 335
// 642 338
// 649 342
// Explanation Of Sample Input 2:
// Test case 1:
// For the first test case of sample output 2, we have all celsius temperatures for the Fahrenheit range of 50 to 150.




public class FarenheitToCelcius {

	public static List<List<Integer>> fahrenheitToCelsius(int s, int e, int w) {
		// Write your code here
		List<List<Integer>> result=new ArrayList<>();
		
		for(int i=s;i<=e;i+=w){

			int f=i;
			int c=(int)((5.0/9)*(f-32));
			List<Integer> row=new ArrayList<>();
			row.add(f);
			row.add(c);
			result.add(row);
			
		}
		
		return result;


	}
  public static void main(String[] args) {
        // Static input for test cases (this can be modified)
        int[][] testCases = {
            {0, 100, 20},  // First test case: start=0, end=100, step=20
            {25, 50, 25}   // Second test case: start=25, end=50, step=25
        };

        // Process each test case
        for (int[] testCase : testCases) {
            int s = testCase[0];
            int e = testCase[1];
            int w = testCase[2];

            // Get the result for the current test case
            List<List<Integer>> result = fahrenheitToCelsius(s, e, w);
            
            // Print the output for the current test case
            for (List<Integer> row : result) {
                System.out.println(row.get(0) + " " + row.get(1));
            }
        }
    }

}
