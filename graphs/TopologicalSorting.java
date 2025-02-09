package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;



public class TopologicalSorting {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int n = adj.size();
        int[] visited = new int[n];
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> neighbours : adj) {
            for (int neighbour : neighbours)
                visited[neighbour]++;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0)
                stack.push(i);
        }
        while (!stack.isEmpty()) {
            int node = stack.pop();
            result.add(node);
            for (int neighbour : adj.get(node)) {
                visited[neighbour]--;
                if (visited[neighbour] == 0)
                    stack.push(neighbour);
            }
        }
        return result.size() == n ? result : new ArrayList<>(Arrays.asList(1));

    }

    public static void main(String[] args) {
        System.out.println("Topological sorting of a graph");
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>());
        ArrayList<Integer> result = topologicalSort(adj);
        System.out.println("Topological sorting of the graph is: " + result);
    }
}

