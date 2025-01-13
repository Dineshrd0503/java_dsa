package codingninjas;
//For a given integer array/list 'ARR' of size 'N' containing all distinct values, find the total number of 'Inversions' that may exist.
//
//An inversion is defined for a pair of integers in the array/list when the following two conditions are met.
//
//A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:
//
//        1. 'ARR[i] > 'ARR[j]'
//        2. 'i' < 'j'
//
//Where 'i' and 'j' denote the indices ranging from [0, 'N').
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= N <= 10^5
//        1 <= ARR[i] <= 10^9
//
//Where 'ARR[i]' denotes the array element at 'ith' index.
//
//Time Limit: 1 sec
//Sample Input 1 :
//        3
//        3 2 1
//Sample Output 1 :
//        3
//Explanation of Sample Output 1:
//We have a total of 3 pairs which satisfy the condition of inversion. (3, 2), (2, 1) and (3, 1).
//Sample Input 2 :
//        5
//        2 5 1 3 4
//Sample Output 2 :
//        4
//Explanation of Sample Output 1:
//We have a total of 4 pairs which satisfy the condition of inversion. (2, 1), (5, 1), (5, 3) and (5, 4).
//
//
//Hints:
//        1. Start with the brute force approach.
//        2. Use a modified merge sort.
//3. Iterate through the elements in sorted order and use a Fenwick tree to track the inversions.
public class CountInversionsOfArray {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long[] temp=new long[arr.length];
        long result=mergesort(arr,temp,0,n-1);
        return result;
    }
    private static int mergesort(long[] arr,long[] temp,int l,int r){
        int count=0;
        if(l>=r)
            return count;
        int middle=(l+r)/2;
        count+=mergesort(arr,temp,l,middle);
        count+=mergesort(arr,temp,middle+1,r);
        count+=merge(arr,temp,l,middle,r);
        return count;
    }
    private static int merge(long[] arr,long[] temp,int leftstart,int middle,int rightend){
        int left=leftstart;
        int right=middle+1;
        int index=leftstart;
        int count=0;
        while(left<=middle&&right<=rightend){
            if(arr[left]<=arr[right])
                temp[index++]=arr[left++];
            else{
                temp[index++]=arr[right++];
                count+=(middle-left+1);
            }
        }
        while(left<=middle)
            temp[index++]=arr[left++];
        while(right<=rightend)
            temp[index++]=arr[right++];
        for(int i=leftstart;i<=rightend;i++)
            arr[i]=temp[i];
        return count;

    }

    public static void main(String[] args) {
        long arr[] = {8, 4, 2, 1};
        int n = arr.length;
        System.out.println("Number of inversions are: " + getInversions(arr, n)); // Output: 6
    }
}
