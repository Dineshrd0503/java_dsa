package codingninjas;
//Given a sequence of numbers ‘ARR’. Your task is to return a sorted sequence of ‘ARR’ in non-descending order with help of the merge sort algorithm.
//
//        Example :
//
//Merge Sort Algorithm -
//
//Merge sort is a Divide and Conquer based Algorithm. It divides the input array into two-parts, until the size of the input array is not ‘1’. In the return part, it will merge two sorted arrays a return a whole merged sorted array.
//Sample Input 1 :
//        2
//        7
//        3 4 1 6 2 5 7
//        4
//        4 3 1 2
//Sample Output 1 :
//        1 2 3 4 5 6 7
//        1 2 3 4
//Explanation For Sample Input 1:
//Test Case 1 :
//
//Given ‘ARR’ : { 3, 4, 1, 6, 2, 5, 7 }
//
//Then sorted 'ARR' in non-descending order will be : { 1, 2, 3, 4, 5, 6, 7 }. Non-descending order means every element must be greater than or equal to the previse element.
//
//Test Case 2 :
//
//Given ‘ARR’ : { 4, 3, 1, 2 }
//
//Then sorted 'ARR' in non-descending order will be : { 1, 2, 3, 4 }.
//Sample Input 2 :
//        2
//        4
//        5 4 6 7
//        3
//        2 1 1
//Sample Output 2 :
//        4 5 6 7
//        1 1 2
public class MergeSort {
    public static void mergeSort(int[] arr, int n) {
        int[] temp=new int[n];
        mergesort(arr,temp,0,n-1);
    }
    private static void mergesort(int[] arr,int[] temp,int left,int right){
        if(left>=right)
            return;
        int middle=(left+right)/2;
        mergesort(arr, temp, left, middle);
        mergesort(arr, temp, middle+1, right);
        merge(arr,temp,left,middle,right);
    }
    private static void merge(int[] arr,int[] temp,int leftstart,int middle,int rightend){
        int left=leftstart;
        int right=middle+1;
        int index=leftstart;
        while(left<=middle&&right<=rightend){
            if(arr[left]<=arr[right])
                temp[index++]=arr[left++];
            else
                temp[index++]=arr[right++];
        }
        while(left<=middle)
            temp[index++]=arr[left++];
        while(right<=rightend)
            temp[index++]=arr[right++];
        for(int i=leftstart;i<=rightend;i++)
            arr[i]=temp[i];
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
        System.out.println("Given Array");
        for(int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
        mergeSort(arr, n);
        System.out.println("\nSorted array");
        for(int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
    }

}
