package linkedlists.doublylinkedlists;

import linkedlists.singlylinkedlists.LinkedListUtil;

public class DeleteHead {

    public static Node deleteHead(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node secondNode = head.next;
        head.next = null;
        secondNode.prev = null;
        return secondNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(7);

        n1.next = n2;
        n2.next = n3;

        n2.prev = n1;
        n3.prev = n2;

        DLLUtil.printDoublyLinkedList(n1);
        n1 = deleteHead(n1);
        DLLUtil.printDoublyLinkedList(n1);
    }
}
