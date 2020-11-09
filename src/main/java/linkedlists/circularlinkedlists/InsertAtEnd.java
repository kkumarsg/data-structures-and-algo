package linkedlists.circularlinkedlists;

import linkedlists.singlylinkedlists.Node;

public class InsertAtEnd {

    public Node insertAtEndEfficient(Node head, Node node){

        if (head==null) {
            node.setNext(node);
            return node;
        }
        Node first = head.getNext();
        head.setNext(node);
        node.setNext(first);

        int temp = head.getData();
        head.setData(node.getData());
        node.setData(temp);

        return node;
    }

    public Node insertAtEndNaive(Node head, Node node){

        if (head==null) {
            node.setNext(node);
            return node;
        }
        node.setNext(head);
        Node iterator = head;
        while (iterator.getNext()!=head) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        return head;
    }
}
