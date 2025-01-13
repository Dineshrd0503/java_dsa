package codingninjas;
import java.util.*;
public class DivisiblePairs {
    static int countOfDivisiblePairs(int n, int m) {
        int count=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if((i+j)%5==0)
                    count+=1;
            }
        }
        return count;
        // Write your code here.
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Reading values of n and m
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        System.out.print("Enter the value of m: ");
        int m = sc.nextInt();

        // Call the function and get the result
        int result = countOfDivisiblePairs(n, m);

        // Output: Print the number of pairs
        System.out.println("Number of pairs where (i + j) is divisible by 5: " + result);

        sc.close();

    }
}

