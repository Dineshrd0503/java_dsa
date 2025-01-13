package codingninjas;
//Sample Input 1 :
//        2
//        1
//        2
//Sample Output 1 :
//        *
//        *
//        ***
//Sample Input 2 :
//        2
//        3
//        4
//Sample Output 2 :
//        *
//        ***
//        *****
//        *
//        ***
//        *****
//        *******
public class PyramidPattern {
    public static void printPattern(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");
            for(int j=1;j<=2*i-1;j++)
                System.out.print("*");
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");

            System.out.println();
        }
        // Write your code here.
    }
        // Write your code here.
    public static void main(String[] args){
        System.out.println("printing a half pyramid pattern");
        int n=5;
        printPattern(n);
    }


}