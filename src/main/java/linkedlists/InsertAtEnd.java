package linkedlists;

public class InsertAtEnd {

    public static Node insertAtEnd(Node head, int data){
        Node temp = new Node(data);
        if (head==null) {
            return temp;
        }
        Node iterator = head;
        while(iterator.next!=null){
            iterator = iterator.next;
        }
        iterator.next = temp;
        return head;
    }
}
