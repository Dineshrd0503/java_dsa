public class QuickSort2 {
    public static void main(String[] args) {
        int[] a={90,1,34,12,7,9,31};
        int n=a.length;
        System.out.println("Unsorted array:");
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");

        quicksortm(a,0,n-1);
        System.out.println("\nSorted array:");
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
            

    }
    public static void quicksortm(int[] a, int low, int high){
        if(low<high){
            int pi=partition(a,low,high);
            quicksortm(a,low,pi-1);
            quicksortm(a,pi+1,high);
        }
    }
    public static int partition(int[] a,int low,int high){
        int pivot=a[high];
        int i=(low-1);
        for(int j=low;j<high;j++){
            if(a[j]<=pivot){
                i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[i+1];
        a[i+1]=a[high];
        a[high]=temp;
        
        return i+1;
    }
}
