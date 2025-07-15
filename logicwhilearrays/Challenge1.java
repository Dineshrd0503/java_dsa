package logicwhilearrays;

import java.util.Scanner;

public class Challenge1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("enter elements of array");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println("cacua;ting evena and odd suma s per element");
        int oddsum=0,evensum=0;
        for(int n1:a) {
            if (n1 % 2 == 0) evensum += n1;
            else oddsum+=n1;
        }
        System.out.println("odd sum "+oddsum+" , "+"even sum "+evensum);
        System.out.println("calcuate using indexes");
        int oddsum1=0,evensum1=0;
        for(int i=0;i<n;i++) {
            if (i % 2 == 0) evensum1+= a[i];
            else oddsum1+=a[i];
        }
        System.out.println("odd sum "+oddsum1+" , "+"even sum "+evensum1);
    }
}
