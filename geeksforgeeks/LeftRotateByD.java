package geeksforgeeks;

public class LeftRotateByD {
static void rotate(int a[],int d){
    int n=a.length;
    d=d%n;
    reverse(a,0,d-1);
    reverse(a,d,n-1);
    reverse(a,0,n-1);
    // add your code here
}
static void reverse(int a[],int start,int end){
    while(start<=end){
        int temp=a[start];
        a[start]=a[end];
        a[end]=temp;
        start++;
        end--;
    }

}

public static void main(String[] args) {
    int a[]={9,8,7,1,3,4};
    int d=3;
    rotate(a,d);
    for(int n1:a)
        System.out.println(n1);

}
}
