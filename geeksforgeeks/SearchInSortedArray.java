package geeksforgeeks;


//Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.
//
//        Examples :
//
//Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
//Output: 8
//Explanation: 3 is found at index 8.
//Input: arr[] = [3, 5, 1, 2], key = 6
//Output: -1
//Explanation: There is no element that has value 6.
//Input: arr[] = [33, 42, 72, 99], key = 42
//Output: 1
//Explanation: 42 is found at index 1
public class SearchInSortedArray {
    public static int search(int[] arr, int key) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==key)
                return mid;
            if(arr[low]<=arr[mid]){
                if(arr[low]<=key&&key<arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(arr[mid]<key&&key<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
        // Complete this function
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int key = 23;
        int result = search(arr, key);
        if (result == -1)
            System.out.println("Element not present in array");
        else
            System.out.println("Element found at index " + result);
    }
}
