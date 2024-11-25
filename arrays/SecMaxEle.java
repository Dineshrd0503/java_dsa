package arrays;

public class SecMaxEle {
    public static void main(String[] args) {
        int[] a={90,3,2,12,65,94,92};
        System.out.println("array elements are");
        for(int n:a)
            System.out.print(n+" ");
        System.out.println();
        int max=-1,secmax=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                secmax=max;
                max=a[i];
            }
            if(a[i]>secmax&&a[i]<max)
                secmax=a[i];
        }
        System.out.println("second max is "+secmax);
    }
}
