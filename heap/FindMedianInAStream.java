package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.
//
//There are two cases for median on the basis of data set size.
//
//        1. If the data set has an odd number then the middle one will be consider as median.
//2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.
//
//Examples:
//
//Input:  arr[] = [5, 15, 1, 3, 2, 8]
//Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0]
//Explanation:
//After reading 1st element of stream – 5 -> median = 5.0
//After reading 2nd element of stream – 5, 15 -> median = (5+15)/2 = 10.0
//After reading 3rd element of stream – 5, 15, 1 -> median = 5.0
//After reading 4th element of stream – 5, 15, 1, 3 ->  median = (3+5)/2 = 4.0
//After reading 5th element of stream – 5, 15, 1, 3, 2 -> median = 3.0
//After reading 6th element of stream – 5, 15, 1, 3, 2, 8 ->  median = (3+5)/2 = 4.0
//Input: arr[] = [2, 2, 2, 2]
//Output: [2.0, 2.0, 2.0, 2.0]
//Explanation:
//After reading 1st element of stream – 2 -> median = 2.0
//After reading 2nd element of stream – 2, 2 -> median = (2+2)/2 = 2.0
//After reading 3rd element of stream – 2, 2, 2 -> median = 2.0
//After reading 4th element of stream – 2, 2, 2, 2 ->  median = (2+2)/2 = 2.0
//Constraints:
//        1 <= arr.size() <= 105
//        1 <= x <= 106



public class FindMedianInAStream {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> result=new ArrayList<>();
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        for(int n:arr){
            if(maxheap.isEmpty()||n<=maxheap.peek())
                maxheap.add(n);
            else
                minheap.add(n);
            if(maxheap.size()>minheap.size()+1)
                minheap.add(maxheap.poll());
            else if(minheap.size()>maxheap.size())
                maxheap.add(minheap.poll());
            if(maxheap.size()>minheap.size())
                result.add((double)maxheap.peek());
            else
                result.add((maxheap.peek()+minheap.peek())/2.0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3};
        FindMedianInAStream obj=new FindMedianInAStream();
        System.out.println(obj.getMedian(arr));
    }

}
