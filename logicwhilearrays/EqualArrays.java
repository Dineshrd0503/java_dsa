package logicwhilearrays;


import java.util.Arrays;

public class EqualArrays {
    public static void main(String[] args) {

    int[] a={1,2,3,4,5};
    int[] b={1,2,3,14,5};
    System.out.println("a arrays is"+ Arrays.toString(a));
    System.out.println("b arrays is"+ Arrays.toString(b));
    System.out.println("chekcing two rrays woth same order and values");
        System.out.println(checkEqualArrays(a,b)?"Equal":"Not equal");
}

    public static boolean checkEqualArrays(int[] a, int[] b) {
        int i=0,j=0;
        if(a.length!=b.length) return false;
        while(i<a.length&&j<b.length){
            if(a[i]!=b[i]) return false;
            i++;
            j++;
        }
        return true;
    }
}
