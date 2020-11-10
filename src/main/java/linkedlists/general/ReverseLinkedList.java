package linkedlists.general;

import linkedlists.singlylinkedlists.Node;

public class ReverseLinkedList {

    public static Node reverseLinkedList(Node head){

        Node prev = null;
        Node current = head;
        while(current!=null){
            Node temp = current.getNext();
            current.setNext(prev);
            prev = current;
            current = temp;
        }

        return prev;
    }
}
