package geeksforgeeks;

public class ReverseArray {
    public void reverseArray(int arr[]) {
        int left=0,right=arr.length-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        // code here
    }

    public static void main(String[] args) {
        ReverseArray obj = new ReverseArray();
        int arr[] = {1, 2, 3, 4, 5};
        obj.reverseArray(arr);
        System.out.println("Reversed array is:");
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
