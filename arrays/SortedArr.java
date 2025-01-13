package arrays;

public class SortedArr {
    public static void main(String[] args) {
        int[] a={1,2,3,4};
        System.out.println("array elements are");
        for(int n:a)
            System.out.print(n+" ");
        System.out.println();
        boolean status=sorted(a);
        System.out.println("array sorted is "+status);
    }
    static boolean sorted(int arr[]){
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=arr[i-1]){

            }
            else
                return false;
        }
        return true;
    }
}
