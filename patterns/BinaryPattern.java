
package patterns;
// Problem statement:
// You have been given an input integer 'N'. Your task is to print the following binary pattern for it.

// Example:
// Pattern for 'N' = 4:
// 1111
// 000
// 11
// 0

// The first line contains 'N' 1s. The next line contains 'N' - 1 0s. Then the next line contains 'N' - 2 1s and so on.

// Input format:
// - The first input is the integer 'T' (number of test cases)
// - For each test case, you are given an integer 'N'

// Output format:
// For each test case, print the binary pattern as per the described pattern for that specific 'N'

// Constraints:
// 1 <= T <= 10    // Number of test cases
// 1 <= N <= 10^3  // The value of N can be as large as 1000

// Time Limit: 1 sec

// Sample Input 1:
// 2
// 1
// 2

// Sample Output 1:
// 1
// 11
// 0

// Sample Input 2:
// 2
// 3
// 5

// Sample Output 2:
// 111
// 00
// 1
// 11111
// 0000
// 111
// 00
// 1

// Plan:
// - For each test case, you will print the binary pattern based on the value of N.
// - You will alternate between 1s and 0s in each line.
// - Print the lines with decreasing length from N down to 1, with alternating binary values.

// Pseudocode:
// 1. Read the number of test cases, T.
// 2. For each test case:
//    - Read the value of N.
//    - For each line, from N down to 1:
//       - If the line number is odd, print 1s.
//       - If the line number is even, print 0s.







public class BinaryPattern{
public static void print(int n) {
		// Write your code here.
		for(int i=1;i<=n;i++){
			for(int j=i;j<=n;j++){
				if(i%2==0)
				System.out.print(0);
				else
				System.out.print(1);
			}
			System.out.println();

		}
		
	}
	public static void main(String[] args) {
		System.out.println("printing the binary pattern");
		int n=4;
		print(n);
	}
}
