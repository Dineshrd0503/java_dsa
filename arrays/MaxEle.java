package arrays;

public class MaxEle {
    public static void main(String[] args) {
        int[] a={90,3,2,12,65,34,98};
        System.out.println("array elements are");
        for(int n:a)
            System.out.print(n+" ");
        int max=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>max)
                max=a[i];
        }
        System.out.println("maximum elemt is "+max);

    }
}
