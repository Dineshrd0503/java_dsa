package linkedlists;
class node1{
    int data;
    node1 next;
    node1(int data){
        this.data=data;
        this.next=null;
    }
}
public class SearchLL{
    node1 head;
    public int size=0;
    public void addnode(int data){
        node1 newnode=new node1(data);
        if(head==null)
            head=newnode;
        else{
            node1 temp=head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next=newnode;
        }
    }
    public int search(int key) {
        if (head == null)
            return -1;
        int index = 0;
        node1 temp = head;
        while (temp!= null) {
            index += 1;
            if (temp.data == key)
                return index;
            temp = temp.next;
        }
        return -1;
    }
    public void addlast(int data){
        node1 newnode=new node1(data);
        node1 temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=null;
    }
        public void display(){
            node1 temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ->");
                temp=temp.next;

            }
            System.out.print("null");
        }

    public static void main(String[] args) {
        SearchLL list = new SearchLL();
        list.addnode(1);
        list.addnode(2);
        list.addnode(3);
        list.addnode(4);
        list.addlast(6);
        list.display();
        System.out.println("Search 3: "+list.search(3));
        list.display();
    }
    }
