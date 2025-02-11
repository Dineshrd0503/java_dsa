import java.util.*;


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
