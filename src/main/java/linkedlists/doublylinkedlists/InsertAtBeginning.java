package linkedlists.doublylinkedlists;

public class InsertAtBeginning {

    public static Node insertAtBeginning(Node head, int data){
        Node nodeToInsert = new Node(data);
        if(head==null){
            return nodeToInsert;
        }
        nodeToInsert.next = head;
        head.prev = nodeToInsert;
        return nodeToInsert;
    }
}
