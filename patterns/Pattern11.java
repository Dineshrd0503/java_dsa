package patterns;
public class Pattern11 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = n; i >=1;i--) {
            for(int j=1;j<=n-i;j++) // changed from n-i-1 to n-i
                System.out.print(" ");
            for(int k=1;k<=2*i-1;k++) // changed from 2*i+1 to 2*i-1
                System.out.print("*");
            for(int j=1;j<=n-i;j++) // changed from n-i-1 to n-i
                System.out.print(" ");
            System.out.println();
        }
    }
}