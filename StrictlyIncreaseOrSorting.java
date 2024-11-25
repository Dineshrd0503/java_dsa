public class StrictlyIncreaseOrSorting{
    public static void main(String[] args){
        int[] a={1,2,3,4,5,6,7,8};
        if(issorted(a,0))
        System.out.println("Array is strictly increasing or sorted");
        else
        System.out.println("Array is not strictly increasing or not sorted");
    }
    public static boolean  issorted(int[] a, int index){
        if(index==a.length-1)
        return true;
        if(a[index]<a[index+1])
            return issorted(a,index+1);
        else
            return false;
    }
    
}