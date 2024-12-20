package geeksforgeeks;
//Given an array arr[]. Push all the zeros of the given array to the right end of the array while maintaining the order of non-zero elements. Do the mentioned change in the array in place.
//
//        Examples:
//
//Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
//Output: [1, 2, 4, 3, 5, 0, 0, 0]
//Explanation: There are three 0s that are moved to the end.
//        Input: arr[] = [10, 20, 30]
//Output: [10, 20, 30]
//Explanation: No change in array as there are no 0s.
//        Input: arr[] = [0, 0]
//Output: [0, 0]
//Explanation: No change in array as there are all 0s.
public class MoveZerosToEnd {
    public  static  void pushZerosToEnd(int[] a) {
        int index=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                if(i!=index){
                    int temp=a[i];
                    a[i]=a[index];
                    a[index]=temp;

                }
                index++;
            }
        }
        // code here
    }

    public static void main(String[] args) {
        int a[]={6,4,0,1,0,2};
        pushZerosToEnd(a);
        for(int n:a)
            System.out.println(a);
    }

}
