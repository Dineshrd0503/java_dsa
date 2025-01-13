package arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] a={0,1,4,0,23,6,0,1,5,0};
        System.out.println("Array before moving zeros to end:");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
        moveZerosToEnd(a);
        System.out.println("Array after moving zeros to end:");
    }

    public static void moveZerosToEnd(int[] a) {
        int index=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                a[index]=a[i];
                index++;
            }
        }
        while(index<a.length){
            a[index]=0;
            index++;

        }
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
}
