package codingninjas;
//You are given a linked list of 'n' nodes and an integer 'k', where 'k' is less than or equal to 'n'.
//
//
//
//Your task is to reverse the order of each group of 'k' consecutive nodes, if 'n' is not divisible by 'k', then the last group of nodes should remain unchanged.
//
//
//
//For example, if the linked list is 1->2->3->4->5, and 'k' is 3, we have to reverse the first three elements, and leave the last two elements unchanged. Thus, the final linked list being 3->2->1->4->5.
//
//
//
//Implement a function that performs this reversal, and returns the head of the modified linked list.
//
//
//
//        Example:
//Input: 'list' = [1, 2, 3, 4], 'k' = 2
//
//Output: 2 1 4 3
//
//Explanation:
//We have to reverse the given list 'k' at a time, which is 2 in this case. So we reverse the first 2 elements then the next 2 elements, giving us 2->1->4->3.
//
//
//Note:
//All the node values will be distinct.
//
//
//        Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        6
//        5 4 3 7 9 2
//        4
//
//
//Sample Output 1:
//        7 3 4 5 9 2
//
//
//Explanation of the Sample Input 1:
//For the given test case, we reverse the nodes in groups of four. But for the last 2 elements, we cannot form a group of four, so leave them as they are. The linked list becomes 7->3->4->5->9->2. Hence the output is 7 3 4 5 9 2
//
//
//Sample Input 2:
//        4
//        4 3 2 8
//        4
//
//
//Sample Output 2:
//        8 2 3 4
//
//
//Expected Time Complexity:
//Try to solve this in O(n).
//
//
//Expected Space Complexity:
//Try to solve this using O(1) extra space.
//
//
//Constraints:
//        1 <= n <= 10^4
//        1 <= k <= n
//
//Time Limit: 1 sec





public class ReverseLLKGroups {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node kReverse(Node head, int k) {
        // If the list is empty or k is less than or equal to 1, return head directly
        if (head == null || k <= 1) {
            return head;
        }

        Node current = head;
        Node newHead = null; // New head of the reversed list
        Node prevTail = null; // Tail of the last processed segment

        while (true) {
            Node kthNode = getNode(current, k); // Get the k-th node

            // If there are not enough nodes left to form a full segment
            if (kthNode == null) {
                if (prevTail != null) {
                    prevTail.next = current; // Connect the last segment to remaining nodes
                }
                break; // Break the loop, we've processed all potential groups of k
            }

            Node nextSegment = kthNode.next; // Store the next segment
            kthNode.next = null; // Break the link

            // Reverse the current segment of k nodes
            Node reversedHead = reverse(current);

            // Set the new head for the first segment
            if (newHead == null) {
                newHead = reversedHead;
            } else {
                prevTail.next = reversedHead; // Connect previous tail to the newly reversed segment
            }

            prevTail = current; // Move to the next segment
            current = nextSegment; // Move to the next segment
        }

        return newHead; // Return the head of the modified list
    }

    // Helper function to reverse the linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev to the current node
            curr = next; // Move to the next node
        }
        return prev; // Return the new head after reversal
    }

    // Helper function to get the k-th node
    private static Node getNode(Node head, int k) {
        Node temp = head;
        while (k > 1 && temp != null) {
            temp = temp.next;
            k--;
        }
        return temp; // Will return null if fewer than k nodes are available
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node newHead = kReverse(head, 3);

        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }

}
