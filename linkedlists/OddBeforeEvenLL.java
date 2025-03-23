package linkedlists;

//Problem statement
//You are given two sorted linked lists of length ‘N1’ and ‘N2’ respectively. Your task is to create a linked list with common elements such that all common odd elements are before common even elements.
//
//Note: The relative order inside both the even and odd groups should remain as it was in the input.
//
//You just need to return the head of the new linked list formed, don't print the elements.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 5
//        0 <= N <= 5 * 10 ^ 6
//        1 <= nodeVal[i] <= 10 ^ 9
//
//Time Limit: 1 sec.
//Sample Input 1:
//        2
//        1 2 3 4 5 7 8 -1
//        2 4 4 7 8 10 -1
//        1 2 7 10 20 23 -1
//        2 7 23 -1
//Sample Output 1:
//        7 2 4 8
//        7 23 2
//Explanation of Sample Input 1:
//In the first test case, the common elements are {2, 4, 7, 8 }. So the elements of the new linked list is 7 -> 2 -> 4 -> 8 -> NULL as odd will come before even maintaining the relative order.
//
//In the second test case, the common elements are {2, 7, 23 }. So the elements of the new linked list is 7 -> 23 -> 2 -> NULL as odd will come before even maintaining the relative order..
//Sample Input 2:
//        2
//        10 11 12 -1
//        1 2 8 9 10 12 12 -1
//        1 2 3 3 4 -1
//        1 2 3 4 -1
//Sample Output 2:
//        10 12
//        1 3 2  4




public class OddBeforeEvenLL {
    public static Node commonOddEven(Node head1, Node head2) {

        // Write your code here
        Node odddummy=new Node(-1);
        Node evendummy=new Node(-1);
        Node oddtail=odddummy;
        Node eventail=evendummy;
        Node curr1=head1;
        Node curr2=head2;
        while(curr1!=null&&curr2!=null){
            if(curr1.data==curr2.data){
                Node newnode=new Node(curr1.data);
                if(newnode.data%2!=0){
                    oddtail.next=newnode;
                    oddtail=newnode;
                }
                else{
                    eventail.next=newnode;
                    eventail=newnode;
                }
                curr1=curr1.next;
                curr2=curr2.next;
            }
            else if(curr1.data<curr2.data)
                curr1=curr1.next;
            else
                curr2=curr2.next;
        }
        oddtail.next=evendummy.next;
        return (odddummy.next!=null)?odddummy.next:evendummy.next;

    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = new Node(10);

        Node result = commonOddEven(head1, head2);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

}
