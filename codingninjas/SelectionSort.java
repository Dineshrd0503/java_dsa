package codingninjas;
//Sort the given unsorted array 'arr' of size 'N' in non-decreasing order using the selection sort algorithm.
//
//
//
//        Note:
//Change in the input array/list itself.
//
//
//Example:
//Input:
//N = 5
//arr = {8, 6, 2, 5, 1}
//
//Output:
//        1 2 5 6 8
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        //Your code goes here
        for(int i=0;i<arr.length-1;i++){
            int minindex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minindex])
                    minindex=j;
            }
            if(minindex!=i){
                int temp=arr[i];
                arr[i]=arr[minindex];
                arr[minindex]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        selectionSort(arr);

        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
