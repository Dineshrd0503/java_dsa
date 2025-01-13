package codingninjas;

import java.util.HashMap;
import java.util.Map;
//You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
//
//        Note :
//Input arrays/lists can contain duplicate elements.
//
//The intersection elements printed would be in the order they appear in the first array/list(ARR1)
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= t <= 10^2
//        0 <= N <= 10^3
//        0 <= M <= 10^3
//Time Limit: 1 sec
//Sample Input 1 :
//        2
//        6
//        2 6 8 5 4 3
//        4
//        2 3 4 7
//        2
//        10 10
//        1
//        10
//Sample Output 1 :
//        2 4 3
//        10
//Sample Input 2 :
//        1
//        4
//        2 6 1 2
//        5
//        1 2 3 4 2
//Sample Output 2 :
//        2 1 2
//Explanation for Sample Output 2 :
//Since, both input arrays have two '2's, the intersection of the arrays also have two '2's. The first '2' of first array matches with the first '2' of the second array. Similarly, the second '2' of the first array matches with the second '2' if the second array.
public class IntersectionOfArrayDuplicates {
    public static void intersections(int arr1[], int arr2[]) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:arr2)
            map.put(n,map.getOrDefault(n,0)+1);
        for(int n:arr1){
            if(map.containsKey(n)&&map.get(n)>0){
                System.out.print(n+" ");
                map.put(n,map.get(n)-1);
            }
        }
        //Your code goes here
    }
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 3, 3, 5, 6};
        int arr2[] = {3, 4, 5, 6, 7, 8, 9};
        intersections(arr1, arr2);
    }

}
