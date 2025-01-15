package geeksforgeeks;
import java.util.Arrays;
//Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.
//
//        Examples:
//
//Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
//Output:
//        2 2 3 4
//        7 10
//Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10
//Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
//Output:
//        1 2 3 5 8 9
//        10 13 15 20
//Explanation: After merging two sorted arrays we get 1 2 3 5 8 9 10 13 15 20.
//Input: a[] = [0, 1], b[] = [2, 3]
//Output:
//        0 1
//        2 3
//Explanation: After merging two sorted arrays we get 0 1 2 3.


public class MergeWithoutExtraSpace {
    public void mergeArrays(int a[], int b[]) {
        // code here
        int m=a.length,n=b.length;
        int i=m-1,j=0;
        while(i>=0&&j<n){
            if(a[i]>=b[j]){
                int temp=a[i];
                a[i]=b[j];
                b[j]=temp;
            }
            i--;
            j++;


        }
        Arrays.sort(a);
        Arrays.sort(b);

    }

    public static void main(String[] args) {
        int a[]={1, 3, 5, 7};
        int b[]={0, 2, 6, 8, 9};
        MergeWithoutExtraSpace obj=new MergeWithoutExtraSpace();
        obj.mergeArrays(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }


}
