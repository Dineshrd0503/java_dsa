package patterns;
public class Pattern12 {
    public static void main(String[] args) {
        int n = 5;
        
        // Print Pattern 10
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=n-i;j++) 
                System.out.print(" ");
            for(int k=1;k<=2*i-1;k++) 
                System.out.print("*");
            for(int j=1;j<=n-i;j++) 
                System.out.print(" ");
            System.out.println();
        }
        
        // Print Pattern 11
        for (int i = n; i >= 1; i--) {
            for(int j=1;j<=n-i;j++) 
                System.out.print(" ");
            for(int k=1;k<=2*i-1;k++) 
                System.out.print("*");
            for(int j=1;j<=n-i;j++) 
                System.out.print(" ");
            System.out.println();
        }
    }
}