package geeksforgeeks;

//You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Your task is to find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.

//Note:
//
//The array follows 0-based indexing.
//The number of rows and columns in the array are denoted by n and m respectively.
//Examples:
//
//Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1], [0,0,0,0]]
//Output: 2
//Explanation: Row 2 contains the most number of 1s (4 1s). Hence, the output is 2.
//Input: arr[][] = [[0,0], [1,1]]
//Output: 1
//Explanation: Row 1 contains the most number of 1s (2 1s). Hence, the output is 1.
//Input: arr[][] = [[0,0], [0,0]]
//Output: -1
//Explanation: No row contains any 1s, so the output is -1.
//Constraints:
//        1 ≤ arr.size(), arr[i].size() ≤ 103
//        0 ≤ arr[i][j] ≤ 1




public class RowWithMax1sInMatrix {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int max=0,index=-1;
        for(int i=0;i<arr.length;i++){
            int count_ones=arr[i].length-findones(arr[i],0,1);
            if(count_ones>max){
                max=count_ones;
                index=i;
            }
        }
        return index;
    }
    private static int findones(int[] arr,int start,int value){
        int low=start;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=value){
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[][]={{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        RowWithMax1sInMatrix obj=new RowWithMax1sInMatrix();
        System.out.println(obj.rowWithMax1s(arr));
    }
}
