package geeksforgeeks;
import java.util.HashSet;
import java.util.Set;
//Given a permutation of size n. The range of values for the array elements is from 0 to n-1. All elements may not be present in the array. If the element is not present then there will be -1 present in the array. Rearrange the array such that arr[i] = i and if arr[i] is not present then -1 at that place. Index i is 0-based.
//
//        Examples:
//
//Input: arr[] = [-1, -1, 6, 1, 9, 3, 2, -1, 4, -1]
//Output: [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
//Explanation: In range 0 to 9, all except 0, 5, 7 and 8 are present. Hence, we print -1 instead of them.
//        Input: arr[] = [0, 1, 2, 3, 4, 5]
//Output: [0, 1, 2, 3, 4, 5]
//Explanation: In range 0 to 5, all number are pr
public class RearrangeArrayElements {
    public static void modifyArray(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int n:arr){
            if(n!=-1)
                set.add(n);
        }
        for(int i=0;i<arr.length;i++)
            arr[i]=set.contains(i)?i:-1;
        // code
    }

    public static void main(String[] args) {
        int[] arr = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
        modifyArray(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }


}
