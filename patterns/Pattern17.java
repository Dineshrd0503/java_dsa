package patterns;
public class Pattern17 {
    public static void main(String[] args) {
        int n=5;
        System.out.println("pyramid with numbers fomr decrement to increment");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int k=i;k>=1;k--){
                System.out.print(k);
            }
            for(int k=2;k<=i;k++){
                System.out.print(k);
            }

            System.out.println();
        }
        System.out.println("pyramid with numbers fomr increment to decrement");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=2*i-1;k++){
                System.out.print(k);
            }
            System.out.println();
        }
        System.out.println("printitng a pyramid pattern with increment and decrement fashnion");
        for(int i=0;i<n;i++){
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");
            for(int k=1;k<=i+1;k++)
                System.out.print(k);
            for(int k=i;k>=1;k--)
                System.out.print(k);
            System.out.println();


        }
    }
    
}
