package geeksforgeeks;
import java.util.PriorityQueue;

//Given an array of points where each point is represented as points[i] = [xi, yi] on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
//
//The distance between two points on the X-Y plane is the Euclidean distance, defined as:
//
//sqrt( (x2 - x1)2 + (y2 - y1)2 )
//
//Note: You can return the k closest points in any order, driver code will sort them before printing.
//
//        Examples:
//
//Input: k = 2, points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
//Output: [[-2, 2], [0, 1]]
//Explanation: The Euclidean distances from the origin are:
//Point (1, 3) = sqrt(10)
//Point (-2, 2) = sqrt(8)
//Point (5, 8) = sqrt(89)
//Point (0, 1) = sqrt(1)
//The two closest points to the origin are [-2, 2] and [0, 1].

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<int[]> maxheap=new PriorityQueue<>((a,b)->
                Integer.compare((b[0]*b[0]+b[1]*b[1]),(a[0]*a[0]+a[1]*a[1])));
        for(int[] point:points){
            maxheap.offer(point);
            if(maxheap.size()>k)
                maxheap.poll();
        }
        int[][] result=new int[k][2];
        for(int i=k-1;i>=0;i--)
            result[i]=maxheap.poll();
        return result;

    }
    public static void main(String[] args) {
        int[][] points={{1,3},{-2,2}};
        int k=1;
        KClosestPointsToOrigin obj=new KClosestPointsToOrigin();
        int[][] result=obj.kClosest(points,k);
        for(int[] point:result)
            System.out.println(point[0]+" "+point[1]);
    }
}
