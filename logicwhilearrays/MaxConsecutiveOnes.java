package logicwhilearrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] a = {1, 1, 0, 1, 1, 1};
        System.out.println(maxConsecutiveOnes(a));
    }
    public static int maxConsecutiveOnes(int[] a) {
        int maxcount = 0,count=0;
        for(int n:a){
            if(n==1){
                count++;
                maxcount=Math.max(count,maxcount);
            }
            else
                count=0;
        }
        return maxcount;

    }
}
