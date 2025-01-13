package codingninjas;

import java.util.ArrayList;
import java.util.List;
//Problem statement
//You are given a list of ‘N’ non-overlapping intervals (each interval can be represented using two integers ‘start’ and ‘end’), sorted in ascending order (based on ‘start’ values). Your task is to insert a given interval in the list, such that all the intervals are present in sorted order.
//
//In case the given interval overlaps with other intervals, merge all necessary intervals to produce a list containing only non-overlapping intervals.
//
//Example:
//
//Let’s say the list of intervals is: [[1,3], [5,7], [8,12]] and we need to insert the interval [4,6] into the list. [4,6] must be inserted in the second position. After insertion, since [4,6] overlaps with [5,7], we merge them into one interval [4,7]. So, our resulting list is:  [[1,3], [4,7], [8,12]]
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= N <= 5 * 10^4
//        1 <= start <= end <= 10^5
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        3
//        1 3
//        5 7
//        8 12
//        4 6
//        2
//        2 3
//        5 8
//        1 9
//Sample Output 1:
//        1 3
//        4 7
//        8 12
//        1 9
//Explanation 1:
//For the first test case,  The list of intervals is: [[1,3], [5,7], [8,12]] and we need to insert the interval [4,6] into the list. [4,6] must be inserted in the second position. After insertion, since [4,6] overlaps with [5,7], we merge them into one interval [4,7]. So, our resulting list is:  [[1,3], [4,7], [8,12]]

//For the second test case, N = 2. The list of intervals is: [[2,3], [5,8]] and we need to insert the interval [1,9] into the list. [4,6] must be inserted in the first position. After insertion, since it overlaps with [2,3] and [5,8], we merge them into one interval [1,9]. So, our resulting list is:  [[1,9]].
//Sample Input 2:
//        2
//        3
//        1 3
//        5 7
//        8 12
//        4 10
//        2
//        2 3
//        5 10
//        1 4
//Sample Output 2:
//        1 3
//        4 12
//        1 4
//        5 10
public class InsertIntervals {
    public static ArrayList<ArrayList<Integer>> insertInterval(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newinterval)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList();
        int i=0,j=intervals.size();
        while(i<j&&intervals.get(i).get(1)<newinterval.get(0)){
            result.add(intervals.get(i));
            i++;
        }
        while(i<j&&intervals.get(i).get(0)<=newinterval.get(1)){
            newinterval.set(0,Math.min(intervals.get(i).get(0),newinterval.get(0)));
            newinterval.set(1,Math.max(intervals.get(i).get(1),newinterval.get(1)));
            i++;
        }
        result.add(newinterval);
        while(i<j){
            result.add(intervals.get(i));
            i++;
        }
        return result;
        // Write your code here.
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        intervals.add(new ArrayList<>(List.of(1, 2)));
        intervals.add(new ArrayList<>(List.of(3, 5)));
        intervals.add(new ArrayList<>(List.of(6, 7)));
        intervals.add(new ArrayList<>(List.of(8, 10)));
        intervals.add(new ArrayList<>(List.of(12, 16)));

        ArrayList<Integer> newInterval = new ArrayList<>(List.of(4, 8));

        ArrayList<ArrayList<Integer>> result = insertInterval(intervals, newInterval);

        for (ArrayList<Integer> interval : result) {
            System.out.println(interval.get(0) + " " + interval.get(1));
        }
    }

}
