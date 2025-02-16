package geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions
//
//serialize() : stores the tree into an array a and returns the array.
//deSerialize() : deserializes the array to the tree and returns the root of the tree.
//        Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).
//
//Examples :
//
//Input: root = [1, 2, 3]
//
//Output: [2, 1, 3]
//Input: root = [10, 20, 30, 40, 60, N, N]
//
//Output: [40, 20, 60, 10, 30]
//Constraints:
//        1 <= Number of nodes <= 104
//        1 <= Data of a node <= 109



public class SerializeAndDeserializeBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node==null){
                result.add(null);
                continue;
            }
            result.add(node.data);
            q.add(node.left);
            q.add(node.right);

        }
        return result;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        if(arr==null||arr.get(0)==null||arr.isEmpty())
            return null;
        Queue<Node> q=new LinkedList<>();
        Node root=new Node(arr.get(0));
        q.add(root);
        int index=1;
        while(!q.isEmpty()&&index<arr.size()){
            Node node=q.poll();
            if(index<arr.size()&&arr.get(index)!=null){
                node.left=new Node(arr.get(index));
                q.add(node.left);
            }
            index++;
            if(index<arr.size()&&arr.get(index)!=null){
                node.right=new Node(arr.get(index));
                q.add(node.right);
            }
            index++;






        }
        return root;

    }
    public static void main(String[] args) {
        SerializeAndDeserializeBST obj=new SerializeAndDeserializeBST();
        Node root=new Node(5);
        root.left=new Node(3);
        root.right=new Node(6);
        root.left.left=new Node(2);
        root.left.right=new Node(4);
        root.right.right=new Node(7);
        ArrayList<Integer> result=obj.serialize(root);
        System.out.println(result);
        Node res=obj.deSerialize(result);
        System.out.println(res.data);
    }
}
