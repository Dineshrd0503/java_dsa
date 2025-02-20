package geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

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
        System.out.println("find median in a stream");
        int[] arr={5, 15, 1, 3};
        FindMedianInAStream obj=new FindMedianInAStream();
        ArrayList<Double> result=obj.getMedian(arr);
        for(double d:result)
            System.out.print(d+" ");
    }


}
