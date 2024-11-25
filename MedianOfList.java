import java.util.*;
public class MedianOfList{
public static int findMedian(List<Integer> arr) {
    Collections.sort(arr);
    return arr.get(arr.size()/2);
// Write your code here

}
public static void main(String[] args){
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(10);
    list.add(9);
    list.add(8);
    list.add(98);
    System.out.println("meidan of list is :"+findMedian(list));
}
}
