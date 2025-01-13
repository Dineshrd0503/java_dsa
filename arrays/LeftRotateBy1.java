package arrays;

public class LeftRotateBy1 {
    public static void main(String[] args) {
        int[] a={1,2,3,4,3,2,1,5};
        System.out.println("array elements are");
        for(int n:a)
            System.out.print(n+" ");
        System.out.println();
        System.out.println("left rortaing arr by 1");
        int temp=a[0];
        for(int i=1;i<a.length;i++)
            a[i-1]=a[i];
        a[a.length-1]=temp;
        System.out.println("array elements are");
        for(int n:a)
            System.out.print(n+" ");
        System.out.println();
    }
}
