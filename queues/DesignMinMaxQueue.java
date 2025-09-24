package queues;
import java.util.*;

/*
Design a SpecialQueue data structure that functions like a normal queue but with additional support for retrieving the minimum and maximum element efficiently.
The SpecialQueue must support the following operations:

enqueue(x): Insert an element x at the rear of the queue.
dequeue(): Remove the element from the front of the queue.
getFront(): Return the front element without removing.
getMin(): Return the minimum element in the queue in O(1) time.
getMax(): Return the maximum element in the queue in O(1) time.

There will be a sequence of queries queries[][]. The queries are represented in numeric form:

1 x : Call enqueue(x)
2 :  Call dequeue()
3: Call getFront()
4: Call getMin()
5: Call getMax()

The driver code will process the queries, call the corresponding functions, and print the outputs of getFront(), getMin(), getMax() operations.
You only need to implement the above five functions.

Note: It is guaranteed that all the queries are valid.

Examples:

Input: q = 6, queries[][] = [[1, 4], [1, 2], [3], [4], [2], [5]]
Output: [4, 2, 2]
Explanation: Queries on queue are as follows:enqueue(4): Insert 4 at the rear of the queue.
enqueue(2): Insert 2 at the rear of the queue.
return the front element i.e 4
return minimum element from the queue i.e 2
dequeue(): Remove the front element 4 from the queue
return maximum element from the queue i.e 2

Input: q = 4, queries[][] = [[1, 3], [4], [1, 5], [5]]
Output: [3, 5]
Explanation: Queries on queue are as follows:enqueue(3): Insert 3 at the rear of the queue.
return minimum element from the queue i.e 3
enqueue(5): Insert 5 at the rear of the queue.
return maximum element from the queue i.e 5

Constraints:
1 ≤ queries.size() ≤ 10^5
0 ≤ values in the queue ≤ 10^9
*/

public class DesignMinMaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> minQueue;
    private Deque<Integer> maxQueue;

    public DesignMinMaxQueue() {
        queue = new LinkedList<>();
        minQueue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public void enqueue(int x) {
        queue.offer(x);

        while (!minQueue.isEmpty() && minQueue.peekLast() > x) {
            minQueue.pollLast();
        }
        minQueue.offer(x);

        while (!maxQueue.isEmpty() && maxQueue.peekLast() < x) {
            maxQueue.pollLast();
        }
        maxQueue.offer(x);
    }

    public void dequeue() {
        if (!queue.isEmpty()) {
            int removed = queue.poll();
            if (!minQueue.isEmpty() && removed == minQueue.peek()) {
                minQueue.poll();
            }
            if (!maxQueue.isEmpty() && removed == maxQueue.peek()) {
                maxQueue.poll();
            }
        }
    }

    public int getFront() {
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public int getMin() {
        return minQueue.isEmpty() ? -1 : minQueue.peek();
    }

    public int getMax() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peek();
    }


public static void main(String[] args) {
    // Example 1
    int[][] queries1 = {{1, 4}, {1, 2}, {3}, {4}, {2}, {5}};
    System.out.println("Example 1 Output: " + runQueries(queries1)); // Expected: [4, 2, 2]

    // Example 2
    int[][] queries2 = {{1, 3}, {4}, {1, 5}, {5}};
    System.out.println("Example 2 Output: " + runQueries(queries2)); // Expected: [3, 5]
}

private static List<Integer> runQueries(int[][] queries) {
    DesignMinMaxQueue specialQueue = new DesignMinMaxQueue();
    List<Integer> results = new ArrayList<>();

    for (int[] query : queries) {
        int type = query[0];
        switch (type) {
            case 1:
                specialQueue.enqueue(query[1]);
                break;
            case 2:
                specialQueue.dequeue();
                break;
            case 3:
                results.add(specialQueue.getFront());
                break;
            case 4:
                results.add(specialQueue.getMin());
                break;
            case 5:
                results.add(specialQueue.getMax());
                break;
        }
    }
    return results;
}
}