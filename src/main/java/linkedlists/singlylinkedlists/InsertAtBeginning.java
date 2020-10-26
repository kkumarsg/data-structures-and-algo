package linkedlists.singlylinkedlists;

public class InsertAtBeginning {

    public static Node insertAtBeginning(Node head, int data){
        Node current = new Node(data);
        current.next = head;
        return current;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head = insertAtBeginning(head, 1);
        LinkedListUtil.printLinkedList(head);
    }
}
