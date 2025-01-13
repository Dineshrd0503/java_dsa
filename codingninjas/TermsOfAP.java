package codingninjas;
//Ayush is given a number ‘X’. He has been told that he has to find the first ‘X’ terms of the series 3 * ‘N’ + 2, which are not multiples of 4. Help Ayush to find it as he has not been able to answer.
//
//        Example: Given an ‘X’ = 4. The output array/list which must be passed to Ayush will be [ 5, 11, 14, 17 ].

public class TermsOfAP {
    public static int[] termsOfAP(int x){
        int[] list=new int[x];
        int count=0,n=1;
        while(count<x){
            int term=3*n+2;
            if(term%4!=0){
                list[count]=term;
                count++;
            }
            n++;

            // Write your code here.
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr = termsOfAP(5);
        for(int num : arr)
            System.out.print(num + " ");
    }

}
