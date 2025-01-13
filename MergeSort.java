public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 4, 5, 3, 6};
        System.out.println("Unsorted array:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        divide(arr,0,arr.length-1);
        System.out.println("Sorted array:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");

       
    }
    public static void divide(int[] arr,int start, int end){
        if(start>=end)
        return;
        int mid = start + (end - start) / 2;
        
        divide(arr,start,mid);
        divide(arr,mid+1,end);
        conquer(arr,start,mid,end);
    }
    public static void conquer(int[] arr, int start, int mid, int end){
        int[] merged=new int[arr.length];
        int i=start,j=mid+1,k=start;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j])
                merged[k++]=arr[i++];
            else
                merged[k++]=arr[j++];
        }
        while(i<=mid)
            merged[k++]=arr[i++];
        
        while(j<=end)
            merged[k++]=arr[j++];
            
        for(i=start;i<=end;i++)
        arr[i]=merged[i];
    
}
}
