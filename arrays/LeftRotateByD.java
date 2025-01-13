package arrays;

public class LeftRotateByD {
    public static void main(String[] args) {
        int[] a={1,2,3,4,3,2,1,5};
        System.out.println("array elements are");
        for(int n:a)
            System.out.print(n+" ");
        System.out.println();
        System.out.println("left rortaing arr by 4");
        rotatearr(a,4);
        System.out.println("array elements are");
        for(int n:a)
            System.out.print(n+" ");
        System.out.println();
    }
    static void rotatearr(int arr[], int d) {
        d=d%arr.length;
        int[] temp=new int[d];
        for(int i=0;i<d;i++){
            temp[i]=arr[i];

        }
        for(int i=d;i<arr.length;i++){
            arr[i-d]=arr[i];
        }
        for(int i=arr.length-d;i<arr.length;i++){
            arr[i]=temp[i-(arr.length-d)];
        }

        // add your code here
    }
}
