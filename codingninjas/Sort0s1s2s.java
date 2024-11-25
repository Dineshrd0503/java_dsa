package codingninjas;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0};
        sortarray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sortarray(int[] a) {
        int low=0,mid=0,high=a.length-1;
        while(mid<=high){
            if(a[mid]==0){
                int temp=a[mid];
                a[mid]=a[low];
                a[low]=temp;
                low++;
                mid++;
            }
            else if(a[mid]==1){
                mid++;
            }
            else{
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }

    }
}
