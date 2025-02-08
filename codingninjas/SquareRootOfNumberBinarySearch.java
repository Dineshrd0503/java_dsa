package codingninjas;

public class SquareRootOfNumberBinarySearch {
    public static int squareRoot(int a)
    {
        int start=1,end=a,result=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            long square=(long) mid*mid;
            if(square==a)
                return mid;
            else if(square<a){
                result=mid;
                start=mid+1;

            }
            else{
                end=mid-1;
            }


        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("square root of a number using binary search");
        int a=17;
        System.out.println("square root of "+a+" is "+squareRoot(a));
    }
}
