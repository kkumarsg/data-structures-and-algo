package linkedlists.doublylinkedlists;

public class InsertAtEnd {

    public static Node insertAtEnd(Node head, int data){
        Node newNode = new Node(data);
        if (head==null) {
            return newNode;
        }
        Node iterator = head;
        while(iterator.next!=null){
            iterator = iterator.next;
        }
        iterator.next = newNode;
        newNode.prev = iterator;
        return head;
    }
}
