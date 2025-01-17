package codingninjas;

//Given an array of integers, find all the leaders in the array. An element is a leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader.
//
//        Input:
//int[] a = {16, 17, 4, 3, 5, 2};
//
//Output:
//int[] leaders = {17, 5, 2};



public class LeadersInArray {
    public static void main(String[] args) {
        System.out.println("finding the leaders in array");
        int[] a={16,17,4,3,5,2};
        int[] leaders=leadersInArray(a,a.length);
        for(int i:leaders)
            System.out.print(i+" ");
    }
    public static int[] leadersInArray(int[] a, int n) {
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=n-1;i>=0;i--){
            if(a[i]>=max){
                max=a[i];
                count++;
            }
        }
        int[] leaders=new int[count];
        int j=0;
        for(int i=n-1;i>=0;i--){
            if(a[i]>=max){
                max=a[i];
                leaders[j++]=max;
            }
        }
        return leaders;
        // Write your code here.
    }
}
